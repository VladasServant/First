package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    private UserRepository mockUserRepository; // Макет бази даних
    private UserService userService;          // Сервіс для тестування

    @BeforeEach
    void setUp() {
        // Ініціалізація мок-об'єкта UserRepository та сервісу UserService
        mockUserRepository = mock(UserRepository.class);
        userService = new UserService(mockUserRepository);
    }

    @Test
    void testCreateUser_Success() {
        // Перевірка, чи викликається метод createUser із правильним об'єктом
        User user = new User(1L, "John Doe");

        userService.createUser(user);

        // Перевірка виклику методу createUser у репозиторії
        verify(mockUserRepository, times(1)).createUser(user);
    }

    @Test
    void testGetUserById_Success() {
        // Перевірка, чи повертається правильний користувач з бази даних
        Long userId = 1L;
        User expectedUser = new User(userId, "John Doe");

        // Імітуємо, що репозиторій повертає користувача
        when(mockUserRepository.getUserById(userId)).thenReturn(expectedUser);

        User actualUser = userService.getUserById(userId);

        // Перевірка поверненого користувача
        assertEquals(expectedUser, actualUser);

        // Перевірка виклику методу getUserById
        verify(mockUserRepository, times(1)).getUserById(userId);
    }

    @Test
    void testUpdateUser_Success() {
        // Перевірка, чи викликається метод updateUser із правильними даними
        User user = new User(1L, "Jane Doe");

        userService.updateUser(user);

        // Використовуємо ArgumentCaptor для захоплення аргументів
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(mockUserRepository, times(1)).updateUser(captor.capture());

        // Перевірка переданих даних
        User capturedUser = captor.getValue();
        assertEquals("Jane Doe", capturedUser.getName());
        assertEquals(1L, capturedUser.getId());
    }

    @Test
    void testGetUserById_UserNotFound() {
        // Перевірка, коли користувач із заданим ідентифікатором не знайдений
        Long userId = 1L;

        // Імітуємо, що репозиторій повертає null
        when(mockUserRepository.getUserById(userId)).thenReturn(null);

        User actualUser = userService.getUserById(userId);

        // Перевірка, що повернено null
        assertNull(actualUser);

        // Перевірка виклику методу getUserById
        verify(mockUserRepository, times(1)).getUserById(userId);
    }
}