package Queue;

import com.scv1702.Queue.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedQueueTest {
    private Queue<Integer> queue;

    @DisplayName("offer test")
    @Test
    void offerTest() {
        queue = new LinkedQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertThat(queue.toString()).isEqualTo("[1, 2, 3]");
        queue.offer(4);
        queue.offer(5);
        assertThat(queue.toString()).isEqualTo("[1, 2, 3, 4, 5]");
    }

    @DisplayName("poll test")
    @Test
    void pollTest() {
        queue = new LinkedQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertThat(queue.poll()).isEqualTo(1);
        assertThat(queue.toString()).isEqualTo("[2, 3]");
        assertThat(queue.poll()).isEqualTo(2);
        assertThat(queue.toString()).isEqualTo("[3]");
        assertThat(queue.poll()).isEqualTo(3);
        assertThat(queue.toString()).isEqualTo("[]");
    }

    @DisplayName("peek test")
    @Test
    void peekTest() {
        queue = new LinkedQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertThat(queue.peek()).isEqualTo(1);
        assertThat(queue.toString()).isEqualTo("[1, 2, 3]");
    }

    @DisplayName("size test")
    @Test
    void sizeTest() {
        queue = new LinkedQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertThat(queue.size()).isEqualTo(3);
        queue.poll();
        assertThat(queue.size()).isEqualTo(2);
        queue.poll();
        assertThat(queue.size()).isEqualTo(1);
    }

    @DisplayName("isEmpty test")
    @Test
    void isEmptyTest() {
        queue = new LinkedQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertThat(queue.isEmpty()).isEqualTo(false);
        queue.poll();
        queue.poll();
        queue.poll();
        assertThat(queue.isEmpty()).isEqualTo(true);
    }
}
