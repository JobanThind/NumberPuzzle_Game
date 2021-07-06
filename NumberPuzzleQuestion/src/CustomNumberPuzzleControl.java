import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}

	public int getHeight() {
		return 250;
	}

	public int getXPosition() {
		return 200;
	}

	public int getYPosition() {
		return 200;
	}

	public String getTitle() {
		return "Number Puzzle";
	}

	public int getShuffleButtonFontSize() {
		return 12;
	}

	public int getNumbersFontSize() {
		return 12;
	}

	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}

	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}
	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game) {
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		//Your logic here
		int updatedEmptyCellId = emptyCellId;
		if (
				(emptyCellId == 3 && buttonClicked.equals(buttons[4])) ||
						(emptyCellId == 7 && buttonClicked.equals(buttons[8])) ||
						(emptyCellId == 11 && buttonClicked.equals(buttons[12])) ||
						(emptyCellId == 4 && buttonClicked.equals(buttons[3])) ||
						(emptyCellId == 8 && buttonClicked.equals(buttons[7])) ||
						(emptyCellId == 12 && buttonClicked.equals(buttons[11])) ) {
			return emptyCellId;
		}
		if (emptyCellId + 1 <= 15 && buttonClicked.equals(buttons[emptyCellId + 1])) {
			updatedEmptyCellId = emptyCellId + 1;
		}
		if (emptyCellId - 1 >= 0 && buttonClicked.equals(buttons[emptyCellId - 1])) {
			updatedEmptyCellId = emptyCellId - 1;
		}
		if (emptyCellId + 4 <= 15 && buttonClicked.equals(buttons[emptyCellId + 4])) {
			updatedEmptyCellId = emptyCellId + 4;
		}
		if (emptyCellId - 4 >= 0 && buttonClicked.equals(buttons[emptyCellId - 4])) {
			updatedEmptyCellId = emptyCellId - 4;
		}
		if (emptyCellId != updatedEmptyCellId) {
			swapButton(buttons[emptyCellId], buttonClicked);
		}
		return updatedEmptyCellId;

	}

	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		//Your logic here
		Set<Integer> set = new HashSet<>();
		int i = 0;
		while (set.size() != 15) {
			int a = (getRandomNumber() % 15) + 1;
			if (!set.contains(a)) {
				set.add(a);
				arr[i] = a;
				i++;
			}
		}
		return arr;
	}

	public boolean checkForWinner(Button[] buttons) {
		boolean winner = true;
		// Your Logic here
		int arr[] = getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<15;i++){
			if(arr[i]!=i+1)
				return false;
		}
		return true;
	}
}