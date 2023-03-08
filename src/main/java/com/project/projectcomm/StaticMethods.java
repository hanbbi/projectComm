package com.project.projectcomm;

import com.project.projectcomm.dto.CommImgDto;
import com.project.projectcomm.dto.UserImgDto;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class StaticMethods {
    public static CommImgDto parseIntoCommImg(MultipartFile imgFile,
                                                String imgId,
                                                String imgPath,
                                                int seq) throws Exception {
        CommImgDto commImg = null;
        String[] contentsTypes = Objects.requireNonNull(imgFile.getContentType()).split("/");
        System.out.println("contentsTypes: "+contentsTypes);
        if (contentsTypes[0].equals("image")) {
            String fileName = imgId + "_" + System.currentTimeMillis() + "_"
                    + (int) (Math.random() * 10000) + "." + contentsTypes[1];
            Path path = Paths.get(imgPath + "/" + fileName);
            imgFile.transferTo(path);
            commImg = new CommImgDto();
            commImg.setImgPath(fileName);
            commImg.setCommImgId(imgId);
            commImg.setSeq(seq);
        } else {
            System.out.println("이미지 파일이 아닙니다.");
        }
        return commImg;
    }

    public static UserImgDto parseIntoUserImg(MultipartFile imgFile,
                                              String imgId,
                                              String imgPath) throws Exception {
        UserImgDto userImg = null;
        String[] contentsTypes = Objects.requireNonNull(imgFile.getContentType()).split("/");
        System.out.println("contentsTypes: "+contentsTypes);
        if (contentsTypes[0].equals("image")) {
            String fileName = imgId + "_" + System.currentTimeMillis() + "_"
                    + (int) (Math.random() * 10000) + "." + contentsTypes[1];
            Path path = Paths.get(imgPath + "/" + fileName);
            imgFile.transferTo(path);
            userImg = new UserImgDto();
            userImg.setImgPath(fileName);
            userImg.setUserImgId(imgId);
        } else {
            System.out.println("이미지 파일이 아닙니다.");
        }
        return userImg;
    }
}
