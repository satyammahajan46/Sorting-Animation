import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class InsertionSort {
	private int[] toSort;
	private int next, finished;
	private JComponent toDrawOn;

	public InsertionSort(int[] toSort, JComponent component) {
		this.toSort = toSort;
		next = -1;
		finished = -1;
		toDrawOn = component;
	}

	public void insertSort() throws InterruptedException{
		int i = 1;
		while (i < toSort.length && !Thread.interrupted()) {
			int current = toSort[i];
			
			int j = i - 1;
			
			while (j >= 0 && toSort[j] > current) {
				toSort[j + 1] = toSort[j];
				j = j - 1;
			}
			toSort[j + 1] = current;
			finished = i;
			i = i + 1;
			next = i;
		
			pause();
		}
	}

	public String toString() {
		String result = "";
		for (int i : toSort)
			result += i + " ";
		return result;
	}

	public void pause() throws InterruptedException{
		toDrawOn.repaint();
		Thread.sleep(1000);

	}

	public synchronized void draw(Graphics2D g2) {
		int deltaX = toDrawOn.getWidth() / toSort.length;
		for (int i = 0; i < toSort.length; i++)
		{
			if (i == next)
			{
				g2.setColor(Color.RED);
			}
			else if (i <= finished)
			{
				g2.setColor(Color.GREEN);
			}
			else
			{
				g2.setColor(Color.gray);
			}
			Rectangle r = new Rectangle(i * deltaX, 0, deltaX, toSort[i]);
			g2.fill(r);
			g2.setColor(Color.black);
			g2.draw(r);
		}
	}

}