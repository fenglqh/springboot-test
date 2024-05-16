package com.example.springdemo3.controller;
import com.example.springdemo3.constants.Constant;
import com.example.springdemo3.enums.ResultStatus;
import com.example.springdemo3.model.BookInfo;
import com.example.springdemo3.model.PageResult;
import com.example.springdemo3.model.Result;
import com.example.springdemo3.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;
import java.util.List;

import static com.example.springdemo3.constants.Constant.USER_SESSION_KEY;

@Slf4j
@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/getList")
    public List<BookInfo> getList() {

//        BookService bookService = new BookService(); 控制权交给spring来创建
        List<BookInfo> bookInfos = bookService.getBookList();
        return bookInfos;
    }

    @RequestMapping("/addBook")
    public String addBook(BookInfo bookInfo) {
        // 可以试一试用json接收
        log.info("add book info-----------------------:{}", bookInfo);
        // 1. 参数校验
        if (bookInfo == null || bookInfo.getBookName() == null || bookInfo.getAuthor() == null
        || bookInfo.getCount() == null || bookInfo.getPrice() == null || bookInfo.getCount() <= 0
            || bookInfo.getPublish() == null) {
            return "未填必填项";
        }
        log.info("bookInfo: {}", bookInfo);
        Integer i = bookService.addBook(bookInfo);
        // 2. 合法性检验
        if (i == null || i <= 0) {
            return "添加失败，请联系管理员";
        }
        return "";
    }

    @RequestMapping("/getBookListByPage")
    public Result<PageResult<BookInfo>> getBookListByPage(Integer pageNum, HttpSession session) { // 不可以是int 类型，int 类型不可以为空，在此处不会自动初始化为0
        Result result = new Result();
        // 先进行登录校验
//        Object session_key = session.getAttribute(Constant.USER_SESSION_KEY);
//        if (session_key == null) {
//            result.setCode(ResultStatus.UNLOGIN);
//            result.setErrMsg("用户未登录");
//            return Result.fail();
//        }
        log.info("pageNum: ----------{}", pageNum);
        // 1. 参数校验
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }


        // 2. 逻辑处理
        // 如果查的元素为空呢？ 需要前端来进行控制
        PageResult<BookInfo> bookInfoPageResult = bookService.queryBookListByPage(pageNum);
//        result.setCode(ResultStatus.SUCCESS);
//        result.setResult(bookInfoPageResult);
        result = Result.success(bookInfoPageResult);
        return result;
    }

    @RequestMapping("/getBookListById")
    public BookInfo getBookListById(Integer bookId) { // 注意这里的参数名字，必须和前端传的一样
        log.info("id: --------------{}", bookId);
        // 1. 参数校验
        if (bookId == null || bookId < 1) {
            return null;
        }
        return bookService.queryBookListById(bookId);
    }

    @RequestMapping("/updateBook")
    public String updateBook(BookInfo bookInfo) {
        log.info("bookInfo:----------------- {}", bookInfo);
        // 1. 参数校验
        if (bookInfo == null || bookInfo.getId() == null) {
            return "后台出错，请联系管理员";
        }
        try {
            Integer ret = bookService.updateBook(bookInfo);
            if (ret < 0) {
            return "更新失败";
        }
        } catch (Exception e) {
            log.error("更新图书失败" +  e.getMessage());
            return "更新失败";
        }
        // 判断
//        if (ret < 0) {
//            return "更新失败";
//        }
        return "";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(Integer id) { // 使用逻辑删除
        log.info("bookId: ---------------{}", id);
        if (id == null || id < 1) {
            return "后台出错，请联系管理员";
        }
        Integer ret = bookService.deleteBook(id);
        if (ret < 0) {
            return "更新失败";
        }
        return "";
    }
    @RequestMapping("/batchDeleteBook")
    public String batchDeleteBook(@RequestParam(required = false) List<Integer> ids) {
        log.info("ids: -------------------------------{}", ids);
        if (ids == null) {
            return "后台出错，请联系管理员";
        }
        try {
            Integer ret = bookService.batchDeleteBook(ids);
            if (ret < 0) {
                return "更新失败";
            }
        } catch (Exception e) {
            log.error("e:{}------" + e.getMessage());
            return "后台出错，请联系管理员";
        }

        return "";
    }
}
