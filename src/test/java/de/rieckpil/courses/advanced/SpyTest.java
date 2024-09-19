package de.rieckpil.courses.advanced;

import de.rieckpil.courses.BannedUsersClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class SpyTest {

  @Spy // A spy is not a mock
  private BannedUsersClient bannedUsersClient;

  // A spy invokes the actual real method, unless the method is overwritten. Spies
  // are rarely used.
  @Test
  void spies() {

    Mockito.when(bannedUsersClient.amountOfBannedAccounts()).thenReturn(400);

    System.out.println(bannedUsersClient.amountOfBannedAccounts()); // 400
    System.out.println(bannedUsersClient.banRate()); // 42.42
  }

  @Test
  void spiesGotcha() {
    List spiedList = Mockito.spy(ArrayList.class);

    // Mockito.when(spiedList.get(0)).thenReturn("spy"); // Error

    Mockito.doReturn("spy").when(spiedList.get(0));

    System.out.println(spiedList.get(0)); // "spy"
    System.out.println(spiedList.get(1)); // IndexOutOfBoundsException

  }
}
