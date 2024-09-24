package de.rieckpil.courses.advanced;

import de.rieckpil.courses.JpaUserRepository;
import de.rieckpil.courses.User;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

// since 3.5.0
class ConstructorMockTest {

  @Test
  void constructorMocking() {

    try (MockedConstruction<JpaUserRepository> mocked = Mockito.mockConstruction(JpaUserRepository.class)) {

      JpaUserRepository jpaUserRepository = new JpaUserRepository();

      Mockito.when(jpaUserRepository.findByUsername("duke")).thenReturn(new User());

      assertNotNull(jpaUserRepository.findByUsername("duke"));

      Mockito.verify(jpaUserRepository).findByUsername("duke");
    }

  }

  @Test
  void constructorMockingWithDirectStubbing() {
  }
}
