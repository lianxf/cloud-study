package cn.lianxf.cloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.lianxf.cloud.controller.vo.LogFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * @className LogController
 * @description 日志接口
 * @date 2021/9/10 下午10:46
 * @author little
 * @version 1.0.0
 */
@RequestMapping(value = "/log")
@Controller
public class LogController {

    @Autowired
    private HttpServletResponse response;

    @GetMapping("/dir")
    public ModelAndView logList(ModelAndView model) {
        List<LogFileVO> logList = new ArrayList<>();
        File logDir = new File("log");
        if (logDir.exists() && logDir.isDirectory()) {
            File[] files = logDir.listFiles();
            if (files != null && files.length > 0) {
                for (File file : files) {
                    LogFileVO log = new LogFileVO();
                    log.setFileName(file.getName());
                    log.setFilePath(file.getAbsolutePath());
                    log.setFileSize(FileUtil.readableFileSize(file));
                    log.setUpdateTime(DateUtil.format(new Date(file.lastModified()), DateFormat.getInstance()));
                    logList.add(log);
                }
            }
        }
        model.addObject("logList", logList);
        model.setViewName("logList");
        return model;
    }

    @GetMapping("/download")
    @ResponseBody
    public void download(String filePath) throws Exception{
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=" + URLEncoder.encode(file.getName(), StandardCharsets.UTF_8.displayName()));
            ServletOutputStream out = response.getOutputStream();
            IoUtil.copy(new FileInputStream(file), out);
            out.flush();
        }
    }

    @GetMapping("/cat")
    public ModelAndView cat(String filePath, ModelAndView model){
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            try {
                String cmd = "cat " + filePath;
                Process process = Runtime.getRuntime().exec(cmd);
                LineNumberReader br = new LineNumberReader(new InputStreamReader(
                        process.getInputStream()));
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    sb.append(line).append("\n");
                }
                model.addObject("logStr", sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
                model.addObject("logStr", e.getMessage());
            }
        }
        model.setViewName("log");
        return model;
    }

    @GetMapping("/cat2")
    public ModelAndView cat2(String filePath, ModelAndView model){
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            try (FileInputStream in = new FileInputStream(file);) {
                StringJoiner sj = new StringJoiner("\n");
                BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8.displayName()));
                String line = null;
                do {
                    line = reader.readLine();
                    sj.add(line);
                } while (StrUtil.isNotBlank(line));
                model.addObject("logStr", sj.toString());
            } catch (Exception e) {
                e.printStackTrace();
                model.addObject("logStr", e.getMessage());
            }
        }
        model.setViewName("log");
        return model;
    }
}
