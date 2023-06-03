import java.awt.event.*;
import javax.swing.*;

public class ControlComponent extends JPanel {
	private JButton run, stop;
	private InsertComponent is;
	
	public ControlComponent() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		is = new InsertComponent();
		add(is);
		
		run = new JButton("Run");
		run.addActionListener(new ControlListener());
		stop = new JButton("Stop");
		stop.addActionListener(new ControlListener());

		
		JPanel organizer = new JPanel();
		organizer.setLayout(new BoxLayout(organizer, BoxLayout.X_AXIS));
		organizer.add(run);
		organizer.add(stop);

		add(organizer);
	}

	private class ControlListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if (e.getSource() == run) {
				is.startAnimation();
			}else if (e.getSource() == stop) {
				try {
					is.stop();
				} catch (InterruptedException e1) {
					System.out.println("Cannot stop animation");
				}
			}
		}
	}
}
