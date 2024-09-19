package de.rieckpil.courses.verification;

import de.rieckpil.courses.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.WARN) // IMPORTANT!
public class RegistrationServiceVerificationTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private BannedUsersClient bannedUsersClient;

  @Captor
  private ArgumentCaptor<User> userArgumentCaptor;

  @Captor
  private ArgumentCaptor<String> stringArgumentCaptor;

  @Captor
  private ArgumentCaptor<Address> addressArgumentCaptor;

  @InjectMocks
  private RegistrationService cut;

  @Test
  void basicVerification() {
    when(bannedUsersClient.isBanned(eq("duke"), any(Address.class))).thenReturn(true);

    assertThrows(IllegalArgumentException.class,
        () -> cut.registerUser("duke", Utils.createContactInformation("duke@java.com")));

    Mockito.verify(bannedUsersClient).isBanned(eq("duke"),
        argThat(address -> address.getCity().equals("Berlin")));

    // Some verify methods
    Mockito.verify(bannedUsersClient, times(1)).isBanned(eq("duke"), any(Address.class));
    Mockito.verify(bannedUsersClient, atLeastOnce()).isBanned(eq("duke"), any(Address.class));
    Mockito.verify(bannedUsersClient, atMost(1)).isBanned(eq("duke"), any(Address.class));
    Mockito.verify(bannedUsersClient, never()).bannedUserId();

    // custom error message
    Mockito.verify(bannedUsersClient, description("Nobody checked for mike")).isBanned(eq("mike"), any(Address.class));
  }

  @Test
  void additionalVerificationOptions() {
  }

  @Test
  void argumentCaptorsWhenVerifying() {
  }
}
