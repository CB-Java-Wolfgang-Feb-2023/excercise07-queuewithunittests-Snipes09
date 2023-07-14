package Hausübung.excercise07_queueWithUnitTests;

import Hausübung.excercise07_queueWithUnitTests.MyQueue;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class QueueWithUnitTests {
    private MyQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new MyQueue();
    }

    @Nested
    @DisplayName("enqueue method")
    class EnqueueMethod {
        @Test
        @DisplayName("should add element to the queue")
        public void shouldAddElementToQueue() {
            queue.enqueue(1);
            assertFalse(queue.isEmpty());
        }

        @Test
        @DisplayName("should resize the queue when it is full")
        public void shouldResizeQueueWhenFull() {
            for (int i = 0; i < 10; i++) {
                queue.enqueue(i);
            }
            queue.enqueue(10);
            assertEquals(20, queue.getCapacity());
        }
    }

    @Nested
    @DisplayName("dequeue method")
    class DequeueMethod {
        @Test
        @DisplayName("should remove element from the queue")
        public void shouldRemoveElementFromQueue() {
            queue.enqueue(1);
            int element = queue.dequeue();
            assertTrue(queue.isEmpty());
            assertEquals(1, element);
        }

        @Test
        @DisplayName("should throw an exception when the queue is empty")
        public void shouldThrowExceptionWhenQueueIsEmpty() {
            assertThrows(IllegalArgumentException.class, () -> {
                queue.dequeue();
            });
        }
    }

    @Nested
    @DisplayName("toString method")
    class ToStringMethod {
        @Test
        @DisplayName("should return a string representation of the queue")
        public void shouldReturnStringRepresentationOfQueue() {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            assertEquals("1, 2, 3", queue.toString());
        }
    }
}
