package de.rieckpil.courses.mocking;

import de.rieckpil.courses.BannedUsersClient;
import de.rieckpil.courses.RegistrationService;
import de.rieckpil.courses.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegistrationServiceV1Test {

  private UserRepository userRepository = Mockito.mock(UserRepository.class);
  private BannedUsersClient bannedUsersClient = Mockito.mock(BannedUsersClient.class);
  private RegistrationService cut = new RegistrationService(userRepository, bannedUsersClient);

  /*
  How Mockito works: https://medium.com/@gorali/how-mockito-works-7d3a2c77da71
  userRepository is not an instance of UserRepository, and it only exists
  in execution time.
  */
  @Test
  void shouldRegisterUnknownUser() {
    System.out.println("============== Mocking UserRepository ==============");
    System.out.println(userRepository.toString());
    System.out.println(userRepository.getClass());

    System.out.println("============== Mocking BannedUsersClient ==============");
    System.out.println(bannedUsersClient.toString());
    System.out.println(bannedUsersClient.getClass());
  }

}
