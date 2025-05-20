package com.nanwe.push.service.impl;

import com.nanwe.push.dto.PushSendRequestDto;
import com.nanwe.push.entity.*;
import com.nanwe.push.repository.*;
import com.nanwe.push.service.FcmService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PushSendServiceImplTest {

    @InjectMocks
    private PushSendServiceImpl pushSendService;

    @Mock private PushSendRepository pushSendRepository;
    @Mock private PushAppRepository pushAppRepository;
    @Mock private PushSendUserRepository pushSendUserRepository;
    @Mock private PushSendListRepository pushSendListRepository;
    @Mock private PushWebSendListRepository pushWebSendListRepository;
    @Mock private PushSendStackRepository pushSendStackRepository;
    @Mock private PushAppUserTokenRepository pushAppUserTokenRepository;
    @Mock private FcmService fcmService;

    @Test
    void testSendPush() {

        // Given
        PushSendRequestDto request = PushSendRequestDto.builder()
                                    .appId("MOBILE")
                                    .noticeTitle("Test Title")
                                    .noticeBody("Test Body")
                                    .noticeImg("http://example.com/image.png")
                                    .noticeUrl("http://example.com")
                                    .noticeAction("open_notice_detail")
                                    .userId("admin")
                                    .userNm("관리자")
                                    .userMobile("010-0000-0000")
                                    .sendUserList("user1,user2")
                                    .pushUse("Y")
                                    .smsUse("N")
                                    .webUse("Y")
                                    .userNmAt("N")
                                    .build();

        PushApp app = PushApp.builder()
                        .pushUseAt("Y")
                        .smsUseAt("N")
                        .webUseAt("Y")
                        .build();
        when(pushAppRepository.findById("MOBILE")).thenReturn(Optional.of(app));

        PushSend savedPushSend = PushSend.builder()
                .noticeNo(1L)
                .build();
        when(pushSendRepository.save(any())).thenReturn(savedPushSend);

        List<PushSendUser> users = List.of(
                PushSendUser.builder()
                        .userId("nauri")
                        .noticeNo(1L)
                        .appId("MOBILE")
                        .successYn("N")
                        .build(),

                PushSendUser.builder()
                        .userId("nauri1")
                        .noticeNo(1L)
                        .appId("MOBILE")
                        .successYn("N")
                        .build()
        );
        when(pushSendUserRepository.findByAppIdAndNoticeNo("MOBILE",1L)).thenReturn(users);

        List<PushSendList> pushList = users.stream()
                .map(u -> PushSendList.builder()
                        .appId(u.getAppId()).noticeNo(u.getNoticeNo()).userId(u.getUserId())
                        .successYn("N").build())
                .toList();
        when(pushSendListRepository.findByAppIdAndNoticeNo("MOBILE", 1L))
                .thenReturn(pushList);


        PushAppUserToken token = PushAppUserToken.builder().fcmToken("test_token").build();
        when(pushAppUserTokenRepository.findTopByAppIdAndUserIdAndUseAtOrderByTokenIdDesc(any(),any(),any())).thenReturn(Optional.of(token));


        // When
        pushSendService.sendPush(request);



        // Then
        verify(pushAppRepository).findById("MOBILE");
        verify(pushSendRepository, times(3)).save(any());
        verify(pushSendUserRepository).saveAll(anyList());
        verify(pushSendListRepository, times(2)).saveAll(anyList());
        verify(pushWebSendListRepository).saveAll(anyList());
        verify(fcmService, times(2))
                .sendTo(eq("test_token"), anyString(), anyString());
        verify(pushSendStackRepository).save(any());


    }
}