package de.rieckpil.courses.stubbing;

import de.rieckpil.courses.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class RegistrationServiceTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private BannedUsersClient bannedUsersClient;

  @InjectMocks
  private RegistrationService cut;

  @Test
  void defaultBehaviour() {
    System.out.println(userRepository.findByUsername("mike"));
    System.out.println(userRepository.save(new User()));
    System.out.println(bannedUsersClient.isBanned("mike", new Address()));
    System.out.println(bannedUsersClient.amountOfBannedAccounts());
    System.out.println(bannedUsersClient.amountOfGloballyBannedAccounts());
    System.out.println(bannedUsersClient.banRate());
    System.out.println(bannedUsersClient.bannedUserId());
  }

  @Test
  void basicStubbing() {
  }

  @Test
  void basicStubbingWithArgumentMatchers() {
  }

  @Test
  void basicStubbingUsageThrows() {
  }

  @Test
  void basicStubbingUsageCallRealMethod() {
  }

  @Test
  void basicStubbingUsageThenAnswer() {
  }

  @Test
  void shouldNotAllowRegistrationOfBannedUsers() {
  }

  @Test
  void shouldAllowRegistrationOfNewUser() {
  }
}
