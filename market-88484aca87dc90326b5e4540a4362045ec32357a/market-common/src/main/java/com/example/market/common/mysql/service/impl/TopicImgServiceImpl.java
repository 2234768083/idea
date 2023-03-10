package com.example.market.common.mysql.service.impl;

import com.example.market.common.mysql.entity.FileInfo;
import com.example.market.common.mysql.entity.TopicImg;
import com.example.market.common.mysql.repo.TopicImgRepository;
import com.example.market.common.mysql.service.FileInfoService;
import com.example.market.common.mysql.service.TopicImgService;
import com.example.market.common.utils.FileUtils;
import com.example.market.common.utils.module.UploadFile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2019/06/20 15:47
 * description:
 */
@AllArgsConstructor
@Service
public class TopicImgServiceImpl implements TopicImgService {

    private final TopicImgRepository topicImgRepository;

    private final FileInfoService fileInfoService;

    @Override
    public void deleteById(Long aLong) {
        topicImgRepository.findById(aLong).ifPresent(topicImg -> {
            topicImg.setDeleteState(DELETED);
            topicImgRepository.save(topicImg);
        });
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveTopicImgFile(HttpServletRequest request, Long topicId, Short topicType) {
        String folderPath = FileUtils.getFolderPath(FOLDER_IMG);
        List<UploadFile> uploadFile = FileUtils.batchUploadFile(request, folderPath);
        List<FileInfo> fileInfoList = fileInfoService.saveFileInfo(uploadFile);
        List<TopicImg> topicImgList = fileInfoList.stream().map(FileInfo::getId)
                .map(fileInfoId ->
                        new TopicImg(topicId, topicType, fileInfoId, currentDateTime(), UN_DELETED))
                .collect(toList());
        topicImgRepository.saveAll(topicImgList);
    }

    @Override
    public Map<Long, List<Long>> findTopicImgList(List<Long> topicId, Short topicType) {
        List<TopicImg> topicImgList = topicImgRepository.findByTopicIdInAndTopicTypeAndDeleteState(topicId, topicType, UN_DELETED);
        return topicImgList.stream().collect(groupingBy(TopicImg::getTopicId, mapping(TopicImg::getImgId, toList())));
    }

}
