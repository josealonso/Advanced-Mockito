package de.rieckpil.courses.stubbing;

import de.rieckpil.courses.BannedUsersClient;
import de.rieckpil.courses.EventNotifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class EventNotifierTest {

  @Mock
  private EventNotifier eventNotifier;

  @Mock
  private BannedUsersClient bannedUsersClient;

  @Test
  void voidMethodStubbing() {
    // Mockito.when(eventNotifier.notifyNewUserCreation("duke")).thenReturn("duke");
    Mockito
        .doNothing()
        .doThrow(new RuntimeException("Error"))
        .when(eventNotifier).notifyNewUserCreation("duke");

    eventNotifier.notifyNewUserCreation("duke");
    assertThrows(RuntimeException.class, () -> eventNotifier.notifyNewUserCreation("duke"));
  }

  @Test
  void doReturnExample() {
    Mockito.doReturn(42).when(bannedUsersClient).amountOfBannedAccounts();
    // doReturn is equivalent to thenReturn, but it is not type safe.
  }
}
