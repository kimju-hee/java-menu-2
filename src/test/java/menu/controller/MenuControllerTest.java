package menu.controller;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import menu.dto.MenuBoard;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.handler.InputHandler;

public class MenuControllerTest {

    private MenuController menuController;
    private MenuBoard menuBoard;
    private OutputView outputView;
    private InputView inputView;
    private InputHandler inputHandler;

    @BeforeEach
    void setUp() {
        menuBoard = mock(MenuBoard.class);
        outputView = mock(OutputView.class);
        inputView = mock(InputView.class);
        inputHandler = mock(InputHandler.class);

        menuController = new MenuController(menuBoard, outputView, inputView, inputHandler);
    }

    @Test
    void inputCoachInfo_shouldPopulateCoachInfo() {
        // given
        String inputCoachNames = "Coach1,Coach2";
        String inputFood1 = "김밥,라면";
        String inputFood2 = "떡볶이,순대";

        when(inputHandler.receiveValidCoachNames()).thenReturn(inputCoachNames);
        when(inputHandler.receiveValidCoachFood()).thenReturn(inputFood1).thenReturn(inputFood2);

        // when
        menuController.inputCoachInfo();

        // then
        assertThat(menuController.coachInfo).hasSize(2);
        assertThat(menuController.coachInfo.get("Coach1")).containsExactly("김밥", "라면");
        assertThat(menuController.coachInfo.get("Coach2")).containsExactly("떡볶이", "순대");
    }

    @Test
    void chooseFood_shouldAddValidFoodToCoachResult() {
        // given
        String category = "일식";
        String coachName = "Coach1";
        List<String> initialFoodList = Arrays.asList("김밥");

        // MenuController의 실제 객체 사용
        MenuController menuController = new MenuController(menuBoard, outputView, inputView, inputHandler);
        menuController.coachResult = new LinkedHashMap<>(); // coachResult 초기화
        menuController.coachResult.put(coachName, initialFoodList);

        // MenuBoard의 mock 객체
        when(menuBoard.getMenuNamesByCategories(category)).thenReturn(
                Arrays.asList("김밥", "라면"));  // Ensure it returns a List<String>

        // when
        menuController.chooseFood(category, coachName);

        // then
        assertThat(menuController.coachResult.get(coachName)).contains("라면");
    }

    @Test
    void getCoachResultByCoachName_shouldReturnCoachResult() {
        // given
        menuController.coachResult.put("Coach1", Arrays.asList("김밥", "라면"));

        // when
        List<String> result = menuController.getCoachResultByCoachName("Coach1");

        // then
        assertThat(result).containsExactly("김밥", "라면");
    }
}
