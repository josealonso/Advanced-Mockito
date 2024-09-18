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
@MockitoSettings(strictness = Strictness.LENIENT) // IMPORTANT: default strictness is severe.
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
    Mockito.when(bannedUsersClient.isBanned("duke", new Address())).thenReturn(true);

    System.out.println(bannedUsersClient.isBanned("duke", new Address())); // true
    System.out.println(bannedUsersClient.isBanned("duke", null)); // false
    System.out.println(bannedUsersClient.isBanned("mike", new Address())); // false
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
