package com.wmyskxz.demo.web.controller;

import com.github.pagehelper.Page;
import com.wmyskxz.demo.config.PageConfig;
import com.wmyskxz.demo.config.UrlConfig;
import com.wmyskxz.demo.module.vo.base.PageResultVo;
import com.wmyskxz.demo.module.vo.base.ResponseVo;
import com.wmyskxz.demo.util.ResultUtil;
import com.wmyskxz.demo.util.UrlCheckUtil;
import com.wmyskxz.demo.web.service.LinkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 链接控制器
 *
 * @auth:wmyskxz
 * @date:2019/04/16 - 15:08
 */
@Controller// 返回JSON数据
@RequestMapping("/")
public class LinkController {
    @Autowired LinkService linkService;

    @ApiOperation("通过短链访问相应的长链,没有则返回主页")
    @GetMapping("/r/{shortCode}")
    public String visit(@PathVariable String shortCode) {
        String longUrl = linkService.get(shortCode);
        if (null == longUrl) {
            // 没有保存对应的长链
            return "redirect:" + UrlConfig.BASE_URL + "?message='系统暂时没有保存对应的长链!'";
        }
        linkService.addVisitByShortUrl(UrlConfig.BASE_SHORT_URL + shortCode);// 增加访问量
        return "redirect:" + longUrl;
    }

    @ApiOperation("查询短链对应的长链")
    @GetMapping("/apis/getLongUrl")
    @ResponseBody
    public ResponseVo getLongUrl(@RequestParam String shortUrl) {
        if (!UrlCheckUtil.isValidShortUrl(shortUrl)) {
            return ResultUtil.error("您输入的网址有问题!");
        }
        String longUrl = null;
        try {
            // 需要把/r/字符去掉所以从index=3的地方开始读取
            longUrl = linkService.get(new URL(shortUrl).getPath().substring(3));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (null == longUrl) {
            // 没有保存对应的长链
            return ResultUtil.error("系统没有保存对应的长链!");
        }
        return ResultUtil.success("查询成功!", longUrl);
    }

    @ApiOperation("通过输入的长链生成或取出对应短链并返回")
    @GetMapping("/apis/getShortUrl")
    @ResponseBody
    public ResponseVo getShortUrl(@RequestParam String longUrl) {
        if (!UrlCheckUtil.isValidLongUrl(longUrl)) {
            return ResultUtil.error("您输入的网址有问题!");
        }
        return ResultUtil.success("转换成功!", linkService.save(longUrl));
    }

    @ApiOperation("自定义绑定长链与短链")
    @GetMapping("/apis/saveShortUrl")
    @ResponseBody
    public ResponseVo saveShortUrl(@RequestParam String longUrl, @RequestParam String shortCode) {
        if (!UrlCheckUtil.isValidLongUrl(longUrl)) {
            return ResultUtil.error("您输入的网址有问题!");
        }   // end if：shortCode的6位长度限制在前端
        String msg = linkService.save(longUrl, shortCode);
        if (msg != null) {
            return ResultUtil.error(msg);
        }
        return ResultUtil.success("绑定成功!");
    }

    @ApiOperation("查询所有Link数据")
    @GetMapping("/apis/list")
    @ResponseBody
    public PageResultVo list(@RequestParam(defaultValue = PageConfig.PAGE_NUM) int pageNum,
                             @RequestParam(defaultValue = PageConfig.PAGE_SIZE) int pageSize) {
        Page page = new Page(pageNum, pageSize);
        return ResultUtil.table(linkService.list(page), linkService.count());
    }
}
