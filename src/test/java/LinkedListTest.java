import com.scv1702.List.*;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    @DisplayName("addFirst()")
    @Test
    void addFirstTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        assertThat(list.toString()).isEqualTo("[3, 2, 1]");
    }

    @DisplayName("addLast()")
    @Test
    void addLastTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertThat(list.toString()).isEqualTo("[1, 2, 3]");
    }
}
