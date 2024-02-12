package sample.cafekiosk.spring.api.service.mail;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sample.cafekiosk.spring.api.client.mail.MailSendClient;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistory;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;

@ExtendWith(MockitoExtension.class)
class MailServiceTest {

  @Mock
  private MailSendClient mailSendClient;

  @Mock
  private MailSendHistoryRepository mailSendHistoryRepository;

  @InjectMocks
  private MailService mailService;

  @DisplayName("메일 전송 테스트")
  @Test
  void sendEmail() {
    // when
//    when(mailSendClient.sendEmail(any(), any(), any(), any()))
//        .thenReturn(true);
//    doReturn(true)
//        .when(mailSendClient)
//        .sendEmail(anyString(), anyString(), anyString(), anyString());
    given(mailSendClient.sendEmail(any(), any(), any(), any()))
        .willReturn(true);

    boolean result = mailService.sendMail("", "", "", "");

    // then
    Assertions.assertThat(result).isTrue();
    Mockito.verify(mailSendHistoryRepository, times(1)).save(any(MailSendHistory.class));
  }
}