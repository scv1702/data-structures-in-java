package Stack;
import com.scv1702.Stack.*;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedStackTest {
    private Stack<Integer> stack;

    @DisplayName("push test")
    @Test
    void pushTest() {
        stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.toString()).isEqualTo("[3, 2, 1]");
        stack.push(4);
        stack.push(5);
        assertThat(stack.toString()).isEqualTo("[5, 4, 3, 2, 1]");
    }

    @DisplayName("pop test")
    @Test
    void popTest() {
        stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.toString()).isEqualTo("[2, 1]");
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.toString()).isEqualTo("[1]");
        assertThat(stack.pop()).isEqualTo(1);
        assertThat(stack.toString()).isEqualTo("[]");
    }

    @DisplayName("peek test")
    @Test
    void peekTest() {
        stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.peek()).isEqualTo(3);
        assertThat(stack.toString()).isEqualTo("[3, 2, 1]");
    }

    @DisplayName("size test")
    @Test
    void sizeTest() {
        stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.size()).isEqualTo(3);
        stack.pop();
        assertThat(stack.size()).isEqualTo(2);
        stack.pop();
        assertThat(stack.size()).isEqualTo(1);
    }

    @DisplayName("isEmpty test")
    @Test
    void isEmptyTest() {
        stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.isEmpty()).isEqualTo(false);
        stack.pop();
        stack.pop();
        stack.pop();
        assertThat(stack.isEmpty()).isEqualTo(true);
    }
}
