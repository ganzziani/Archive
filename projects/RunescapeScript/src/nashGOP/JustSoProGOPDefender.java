package nashGOP;

//import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.imageio.ImageIO;

import java.io.IOException;
import java.net.URL;
import com.rsbuddy.script.util.Filter;
import com.rsbuddy.script.util.Timer;
import java.util.ArrayList;

import com.rsbuddy.event.listeners.PaintListener;
import com.rsbuddy.event.events.MessageEvent;
import com.rsbuddy.event.listeners.MessageListener;

import com.rsbuddy.script.wrappers.*;
import com.rsbuddy.script.methods.*;
import com.rsbuddy.script.*;
import com.rsbuddy.script.util.Random;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;

@Manifest(authors = { "JustSoPro" }, keywords = "Miningames", name = "JustSoProGOPDefender", version = 1.00, description = "Getting those tokens so you don't have to.")
public class JustSoProGOPDefender extends ActiveScript implements
		PaintListener, MessageListener, MouseListener {
	public enum State {
		join, offend, defend, craftRunes, exit, error
	};

	private Timer RUN_TIME;

	public static String pass;
	public static String user;

	private int START_TOKENS = 0;
	private int CURRENT_TOKENS = 0;

	public final int GREEN = 1;
	public final int YELLOW = 2;
	private static boolean GUI_ON = false;
	public int TEAM = GREEN;
	private boolean useCentralClicking = true;
	public boolean START = false;
	public boolean TEAM_YELLOW = false;
	public boolean TEAM_GREEN = false;
	public boolean SCORE = false;

	public final int WIZARD_ID[] = { 8038, 8039, 8033, 8040 };
	public final int GUILD_PORTAL_ID = 8019;
	public final int ALTER_PORTAL_ID = 8020;
	public final int YELLOW_ORB = 8025;
	public final int GREEN_ID = 8031;
	public final int YELLOW_ID = 8030;
	public final int GREEN_ORB = 8021;
	public final int ANIMATION = 10132;
	public final int ESS = 1436;
	public final int AIR_ALTER_ID = 2478;
	public final int MIND_ALTER_ID = 2479;
	public final int WATER_ALTER_ID = 2480;
	public final int EARTH_ALTER_ID = 2481;
	public final int FIRE_ALTER_ID = 2482;
	public final int BODY_ALTER_ID = 2483;
	public final int TOKENS = 13650;

	public final int[] REPELLER_ID = { 13644, 13646 };
	public final int[] ATTRACTER_ID = { 13645, 13643 };
	public final int[] BARRIER_ID = { 13648, 13647 };
	public final int[] GUILD_AREA = { 1688, 5460, 1704, 5476 };

	Gui gui = new Gui();

	/*
	 * To change this template, choose Tools | Templates and open the template
	 * in the editor.
	 */

	/*
	 * NewJFrame2.java
	 * 
	 * Created on Jan 8, 2011, 12:59:30 PM
	 */

	/**
	 * 
	 * @author Desiree
	 */
	public class Gui extends javax.swing.JFrame {

		/** Creates new form NewJFrame2 */
		public Gui() {
			initComponents();
		}

		/**
		 * This method is called from within the constructor to initialize the
		 * form. WARNING: Do NOT modify this code. The content of this method is
		 * always regenerated by the Form Editor.
		 */
		@SuppressWarnings("unchecked")
		// <editor-fold defaultstate="collapsed" desc="Generated Code">
		private void initComponents() {

			jLabel1 = new javax.swing.JLabel();
			jCheckBox1 = new javax.swing.JCheckBox();
			jCheckBox2 = new javax.swing.JCheckBox();
			jCheckBox3 = new javax.swing.JCheckBox();
			jLabel2 = new javax.swing.JLabel();
			jTextField1 = new javax.swing.JTextField();
			jLabel3 = new javax.swing.JLabel();
			jTextField2 = new javax.swing.JTextField();
			jButton1 = new javax.swing.JButton();

			setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

			jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
			jLabel1.setText("JustSoProGOPDefender");

			jCheckBox1.setText("Yellow");

			jCheckBox2.setText("Green");

			jCheckBox3.setText("Score");

			jLabel2.setText("Username");

			jLabel3.setText("Password");

			jButton1.setText("Start");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
					getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(layout
					.createParallelGroup(
							javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(
							layout.createSequentialGroup()
									.addGroup(
											layout.createParallelGroup(
													javax.swing.GroupLayout.Alignment.LEADING)
													.addGroup(
															layout.createSequentialGroup()
																	.addGap(34,
																			34,
																			34)
																	.addGroup(
																			layout.createParallelGroup(
																					javax.swing.GroupLayout.Alignment.LEADING)
																					.addGroup(
																							layout.createSequentialGroup()
																									.addComponent(
																											jCheckBox1)
																									.addGap(18,
																											18,
																											18)
																									.addComponent(
																											jCheckBox2))
																					.addComponent(
																							jCheckBox3))
																	.addGap(30,
																			30,
																			30))
													.addGroup(
															layout.createSequentialGroup()
																	.addContainerGap()
																	.addComponent(
																			jLabel1))
													.addGroup(
															layout.createSequentialGroup()
																	.addContainerGap()
																	.addComponent(
																			jTextField1,
																			javax.swing.GroupLayout.DEFAULT_SIZE,
																			184,
																			Short.MAX_VALUE))
													.addGroup(
															layout.createSequentialGroup()
																	.addContainerGap()
																	.addComponent(
																			jLabel2))
													.addGroup(
															layout.createSequentialGroup()
																	.addContainerGap()
																	.addComponent(
																			jLabel3))
													.addGroup(
															layout.createSequentialGroup()
																	.addContainerGap()
																	.addComponent(
																			jTextField2,
																			javax.swing.GroupLayout.DEFAULT_SIZE,
																			184,
																			Short.MAX_VALUE))
													.addGroup(
															layout.createSequentialGroup()
																	.addGap(68,
																			68,
																			68)
																	.addComponent(
																			jButton1)))
									.addContainerGap()));
			layout.setVerticalGroup(layout
					.createParallelGroup(
							javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(
							layout.createSequentialGroup()
									.addContainerGap()
									.addComponent(jLabel1)
									.addGap(7, 7, 7)
									.addGroup(
											layout.createParallelGroup(
													javax.swing.GroupLayout.Alignment.BASELINE)
													.addComponent(jCheckBox1)
													.addComponent(jCheckBox2))
									.addPreferredGap(
											javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(jCheckBox3)
									.addPreferredGap(
											javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(jLabel2)
									.addPreferredGap(
											javax.swing.LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(
											jTextField1,
											javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addGap(11, 11, 11)
									.addComponent(jLabel3)
									.addPreferredGap(
											javax.swing.LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(
											jTextField2,
											javax.swing.GroupLayout.PREFERRED_SIZE,
											javax.swing.GroupLayout.DEFAULT_SIZE,
											javax.swing.GroupLayout.PREFERRED_SIZE)
									.addGap(18, 18, 18)
									.addComponent(jButton1)
									.addContainerGap(
											javax.swing.GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE)));

			pack();
		}// </editor-fold>

		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			setVisible(false);
			if (jCheckBox1.isSelected()) {
				TEAM_YELLOW = true;
			}
			if (jCheckBox2.isSelected()) {
				TEAM_GREEN = true;
			}
			if (jCheckBox3.isSelected()) {
				SCORE = true;
			}

			GUI_ON = false;

		}

		/**
		 * @param args
		 *            the command line arguments
		 */

		// Variables declaration - do not modify
		private javax.swing.JButton jButton1;
		private javax.swing.JCheckBox jCheckBox1;
		private javax.swing.JCheckBox jCheckBox2;
		private javax.swing.JCheckBox jCheckBox3;
		private javax.swing.JLabel jLabel1;
		private javax.swing.JLabel jLabel2;
		private javax.swing.JLabel jLabel3;
		private javax.swing.JTextField jTextField1;
		private javax.swing.JTextField jTextField2;
		// End of variables declaration

	}

	@Override
	public int loop() {
		Mouse.setSpeed(4);
		try {

			switch (getState()) {
			case join:
				joinGame();
			case offend:
				offend();
			case defend:
				defend();

			case craftRunes:
				craftRunes();
			case exit:
				exit();
			}
		} catch (Exception e) {
		}
		return 1000;
	}

	public void exit() {
		Npc exitPortal = Npcs.getNearest(new int[] { 8020 });
		GameObject alter = Objects.getNearest(new int[] { 2478, 2479, 2480,
				2481, 2482, 2483 });
		if (Inventory.getCount(ESS) < 5) {
			if (!exitPortal.isOnScreen()) {
				autoWalk(exitPortal.getLocation());
				// Walking.walkTileMM(exitPortal.getLocation());
				sleep(3000, 5000);
			} else if (Calculations.distanceTo(exitPortal.getLocation()) < 10) {
				clickNPC(exitPortal, "");
				sleep(1500, 2000);
			} else if (Calculations.distanceTo(exitPortal.getLocation()) > 20
					&& Calculations.distanceTo(alter.getLocation()) < 20) {
				Walking.getTileOnMap(alter.getLocation()).clickOnMap();
				sleep(1250, 1650);
			}
		}
	}

	public void autoWalk(Tile inTile) {
		try {
			if (!Calculations.isTileOnMap(inTile)) {
				Walking.findPath(inTile).traverse();
			} else if (!Calculations.isTileOnScreen(inTile)) {
				Walking.stepTowards(inTile);
			} else {
				Walking.findPath(inTile).traverse();
			}
			sleep(Random.nextInt(200, 400));
		} catch (Exception e) {
		}
	}

	public void joinGame() {
		Npc YELLOW_WIZZARD = Npcs.getNearest(YELLOW_ID);
		Npc GREEN_WIZZARD = Npcs.getNearest(GREEN_ID);
		if (Inventory.getCount(BARRIER_ID) < 1) {
			if (Widgets.getComponent(228, 2).isValid()) {
				Widgets.getComponent(228, 2).click(true);
				sleep(743, 812);
			} else if (TEAM_YELLOW == true && TEAM_GREEN == true) {
				Npc wizard = Npcs.getNearest(WIZARD_ID);
				if (Calculations.isTileOnScreen(wizard.getLocation())
						&& Calculations.distanceTo(wizard.getLocation()) <= 4) {
					clickNPC(wizard, "Join-game Wizard");
					sleep(1000, 1500);
				}
				sleep(300);
			} else if (TEAM_YELLOW == true
					&& TEAM_GREEN == false
					&& Calculations.distanceTo(YELLOW_WIZZARD.getLocation()) < 10) {
				clickNPC(YELLOW_WIZZARD, "Join Wizard Vief");
				sleep(1500, 2000);
			} else if (TEAM_YELLOW == true
					&& TEAM_GREEN == false
					&& Calculations.distanceTo(YELLOW_WIZZARD.getLocation()) > 9) {
				Walking.getTileOnMap(YELLOW_WIZZARD.getLocation()).clickOnMap();
			} else if (TEAM_YELLOW == false
					&& TEAM_GREEN == true
					&& Calculations.distanceTo(GREEN_WIZZARD.getLocation()) < 10) {
				clickNPC(GREEN_WIZZARD, "Join Wizard Acantha");
				sleep(1500, 2000);
			} else if (TEAM_YELLOW == false && TEAM_GREEN == true
					&& Calculations.distanceTo(GREEN_WIZZARD.getLocation()) > 9) {
				Walking.getTileOnMap(GREEN_WIZZARD.getLocation()).clickOnMap();
				sleep(300);
			}

		}
		if (Inventory.getCount(BARRIER_ID[0]) > 0) {
			TEAM = YELLOW;
		}
		if (Inventory.getCount(BARRIER_ID[1]) > 0) {
			TEAM = GREEN;
		}
		if (Inventory.getCount(REPELLER_ID[1]) > 0 && SCORE == false) {
			Inventory.getItem(REPELLER_ID[1]).interact("");
			sleep(2000);
		}
		if (Inventory.getCount(REPELLER_ID[0]) > 0 && SCORE == false) {
			Inventory.getItem(REPELLER_ID[0]).interact("");
			sleep(2000);
		}
		CURRENT_TOKENS = Inventory.getCount(true, TOKENS);
		Npc port = Npcs.getNearest(GUILD_PORTAL_ID);
		if (Players.getLocal().isMoving())
			sleep(1000);
		if (port == null) {
			sleep(1000);
		} else {
			if (Calculations.isTileOnScreen(port.getLocation())
					&& Calculations.distanceTo(port.getLocation()) <= 4
					&& TEAM_GREEN == true
					|| Calculations.isTileOnScreen(port.getLocation())
					&& Calculations.distanceTo(port.getLocation()) <= 4
					&& TEAM_YELLOW == true) {
				port.interact("Enter");
				sleep(1000, 1500);
			}
			if (TEAM_GREEN == true || TEAM_YELLOW == true) {
				Walking.getTileOnMap(port.getLocation()).clickOnMap();
				sleep(300, 600);
			} else {
			}
		}
	}

	public void craftRunes() {
		GameObject alter = Objects.getNearest(new int[] { 2478, 2479, 2480,
				2481, 2482, 2483 });
		if (Inventory.getCount(ESS) >= 5) {
			if (Calculations.distanceTo(alter.getLocation()) > 10
					&& !Widgets.getComponent(228, 2).isValid()) {
				Walking.getTileOnMap(alter.getLocation()).clickOnMap();
				sleep(1500, 2000);
				faceObject(alter);
				sleep(850, 1250);
				alter.interact("");
				sleep(850, 1250);
			} else if (Calculations.distanceTo(alter.getLocation()) <= 10
					&& !Widgets.getComponent(228, 2).isValid()) {
				faceObject(alter);
				sleep(500, 650);
				alter.interact("");
				sleep(1500, 1700);
			} else {
				Widgets.getComponent(228, 2).click(true);
				sleep(750, 900);
			}
		}
	}

	public void defend() {
		GameObject YELLOW_BARRIER = Objects.getNearest(new int[] { 38378 });
		GameObject GREEN_BARRIER = Objects.getNearest(new int[] { 38377 });
		GameObject alter = Objects.getNearest(new int[] { 2478, 2479, 2480,
				2481, 2482, 2483 });
		Npc orb;
		if (Inventory.getCount(BARRIER_ID[0]) > 0) {
			TEAM = YELLOW;
		}
		if (Inventory.getCount(BARRIER_ID[1]) > 0) {
			TEAM = GREEN;
		}
		if (TEAM == GREEN) {
			orb = Npcs.getNearest(yOrb);
		} else {
			orb = Npcs.getNearest(gOrb);
		}
		if (SCORE == false) {
			if (Inventory.getCount(new int[] { this.REPELLER_ID[1] }) > 0
					&& SCORE == false) {
				Inventory.getItem(new int[] { this.REPELLER_ID[1] }).interact(
						"");
			}
			if (Inventory.getCount(new int[] { this.REPELLER_ID[0] }) > 0
					&& SCORE == false) {
				Inventory.getItem(new int[] { this.REPELLER_ID[0] }).interact(
						"");
			}
			if (orb != null)
				if (Inventory.getCount(new int[] { this.BARRIER_ID[0] }) > 0) {
					clickNPC(orb, "Repel Green Orb");
					sleep(1000, 1500);
				}
			if (orb != null)
				if (Inventory.getCount(new int[] { this.BARRIER_ID[1] }) > 0) {
					clickNPC(orb, "Repel Yellow Orb");
					sleep(1000, 1500);
				}

			if (((Calculations.isTileOnScreen((YELLOW_BARRIER.getLocation()))) && (this.TEAM == GREEN))
					|| ((Calculations.isTileOnScreen(GREEN_BARRIER
							.getLocation())) && (this.TEAM == YELLOW))) {
				destroyBarrier();
			}
			if ((Players.getLocal().isMoving())
					|| (Players.getLocal().getAnimation() == 10132)) {
				sleep(1500, 2000);
			}
		}
	}

	public void offend() {
		GameObject YELLOW_BARRIER = Objects.getNearest(new int[] { 38378 });
		GameObject GREEN_BARRIER = Objects.getNearest(new int[] { 38377 });
		GameObject alter = Objects.getNearest(new int[] { 2478, 2479, 2480,
				2481, 2482, 2483 });
		Npc orb;
		GameObject Yellow_BARRIER = Objects.getNearest(38378);
		GameObject Green_BARRIER = Objects.getNearest(38377);

		if (Inventory.getCount(BARRIER_ID[0]) > 0) {
			TEAM = YELLOW;
		}
		if (Inventory.getCount(BARRIER_ID[1]) > 0) {
			TEAM = GREEN;
		}
		if (TEAM == GREEN) {
			orb = Npcs.getNearest(gOrb);
		} else {
			orb = Npcs.getNearest(yOrb);
		}
		if (SCORE == true) {
			if (Inventory.getCount(new int[] { this.ATTRACTER_ID[1] }) > 0) {
				Inventory.getItem(new int[] { this.ATTRACTER_ID[1] }).interact(
						"");
			}
			if (Inventory.getCount(new int[] { this.ATTRACTER_ID[0] }) > 0) {
				Inventory.getItem(new int[] { this.ATTRACTER_ID[0] }).interact(
						"");
			}
			if (Calculations.distanceTo(alter.getLocation()) >= 4) {
				Walking.getTileOnMap(alter.getLocation()).clickOnMap();
				sleep(1250, 1750);
			}
			if (Calculations.distanceTo(orb.getLocation()) < 20 && orb != null
					&& Calculations.distanceTo(orb.getLocation()) > 3) {
				clickNPC(orb, "attract");
				sleep(850, 1500);
				if ((Players.getLocal().isMoving())
						|| (Players.getLocal().getAnimation() == 10132)) {
					sleep(850, 1300);
				} else {
					destroyBarrier();
				}
			}
		}
	}

	public void destroyBarrier() {
		GameObject Yellow_BARRIER = Objects.getNearest(38378);
		GameObject Green_BARRIER = Objects.getNearest(38377);
		if (TEAM == GREEN) {
			if (Calculations.distanceTo(Yellow_BARRIER.getLocation()) <= 10
					&& Yellow_BARRIER != null) {
				faceObject(Yellow_BARRIER);
				sleep(500, 750);
				Yellow_BARRIER.interact("Destroy");
				sleep(1000, 1720);
			} else {
			}
		}
		if (TEAM == YELLOW) {
			if (Calculations.distanceTo(Green_BARRIER.getLocation()) <= 10
					&& Green_BARRIER != null) {
				faceObject(Green_BARRIER);
				sleep(500, 750);
				Green_BARRIER.interact("Destroy");
				sleep(1000, 1720);
			} else {
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		p = e.getPoint();
		if (closeButton.contains(p)) {
			showPaint = !showPaint;
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void messageReceived(final MessageEvent evt) {
		final String serverString = evt.getMessage();
		if (evt.getID() == MessageEvent.MESSAGE_SERVER
				&& serverString.contains("yellow orbs")) {
			Npc orb;
			orb = Npcs.getNearest(GREEN_ORB);
			if (orb != null && Inventory.getCount(BARRIER_ID[1]) > 0) {
				Inventory.getItem(BARRIER_ID[1]).interact("Make");
				sleep(600);
				if (orb != null) {
					sleep(1500, 2500);
					Inventory.getItem(BARRIER_ID[1]).interact("Make");
				} else {

					sleep(500, 750);
				}
			} else if (orb != null && Inventory.getCount(BARRIER_ID[1]) > 0) {
				Inventory.getItem(BARRIER_ID[1]).interact("");
				sleep(500, 750);
			} else {
				if (orb == null) {
				}

			}
		}
		if (evt.getID() == MessageEvent.MESSAGE_SERVER
				&& serverString.contains("green orbs")) {
			Npc orb;
			orb = Npcs.getNearest(GREEN_ORB);
			if (orb != null && Inventory.getCount(BARRIER_ID[0]) > 0) {
				sleep(1500, 2500);
				Inventory.getItem(BARRIER_ID[0]).interact("");
				sleep(500, 750);
			} else {
				if (orb != null && Inventory.getCount(BARRIER_ID[0]) > 0) {
					Inventory.getItem(BARRIER_ID[0]).interact("");
					sleep(500, 750);
				} else {
					if (orb == null) {
					}
				}
			}
		}
		if (evt.getID() == MessageEvent.MESSAGE_SERVER
				&& serverString.contains("is getting low")) {
			if (Inventory.getCount(BARRIER_ID[0]) > 0) {
				Inventory.getItem(BARRIER_ID[0]).interact("");
			} else {
				if (Inventory.getCount(BARRIER_ID[1]) > 0) {
					Inventory.getItem(BARRIER_ID[1]).interact("");
				}
			}
		}
	}

	private int clickNPC(Npc npc, String action) {
		for (int i = 0; i < 10; i++) {
			if (isPartiallyOnScreen(npc.getModel())) {
				Point p = useCentralClicking ? getCentralPoint(npc.getModel())
						: getPointOnScreen(npc.getModel(), false);
				if (p == null || !Calculations.isPointOnScreen(p)) {
					continue;
				}
				Mouse.move(p, useCentralClicking ? 3 : 0,
						useCentralClicking ? 3 : 0);
				if (Menu.getItems()[0].contains(action)) {
					Mouse.click(true);
					return 0;
				} else if (Menu.contains(action)) {
					Mouse.click(false);
					sleep(Random.nextInt(100, 200));
					for (int x = 0; x < 4; x++) {
						if (!Menu.contains(action)) {
							break;
						}
						if (Menu.click(action)) {
							return 0;
						}
					}
				}

			}
		}
		{
			int angle = Camera.getAngleTo(npc);
			if (Calculations.distanceTo(npc) < 40
					&& Math.abs(angle - Camera.getCompassAngle()) > 20) {
				Camera.turnTo(npc);
				// (angle + Random.nextInt(-10, 10));
			}
			return -1;
		}
	}

	public void faceObject(GameObject o) {
		Camera.turnTo(o);
	}

	private boolean isPartiallyOnScreen(Model m) {
		return getPointOnScreen(m, true) != null;
	}

	private Point getPointOnScreen(Model m, boolean first) {
		if (m == null)
			return null;
		ArrayList<Point> list = new ArrayList<Point>();
		try {
			Polygon[] tris = m.getTriangles();
			for (int i = 0; i < tris.length; i++) {
				Polygon p = tris[i];
				for (int j = 0; j < p.xpoints.length; j++) {
					Point pt = new Point(p.xpoints[j], p.ypoints[j]);
					if (Calculations.isPointOnScreen(pt)) {
						if (first)
							return pt;
						list.add(pt);
					}
				}
			}
		} catch (Exception e) {
		}
		return list.size() > 0 ? list.get(Random.nextInt(0, list.size()))
				: null;
	}

	private Point getCentralPoint(Model m) {
		if (m == null)
			return null;
		try {
			/* Add X and Y of all points, to get a rough central point */
			int x = 0, y = 0, total = 0;
			for (Polygon poly : m.getTriangles()) {
				for (int i = 0; i < poly.npoints; i++) {
					x += poly.xpoints[i];
					y += poly.ypoints[i];
					total++;
				}
			}
			Point central = new Point(x / total, y / total);
			/* Find a real point on the NPC that is closest to the central point */
			Point curCentral = null;
			double dist = 20000;
			for (Polygon poly : m.getTriangles()) {
				for (int i = 0; i < poly.npoints; i++) {
					Point p = new Point(poly.xpoints[i], poly.ypoints[i]);
					if (!Calculations.isPointOnScreen(p))
						continue;
					double dist2 = distanceBetween(central, p);
					if (curCentral == null || dist2 < dist) {
						curCentral = p;
						dist = dist2;
					}
				}
			}
			return curCentral;
		} catch (Exception e) {
		}
		return null;
	}

	private double distanceBetween(Point p1, Point p2) {
		return Math.sqrt(((p1.x - p2.x) * (p1.x - p2.x))
				+ ((p1.y - p2.y) * (p1.y - p2.y)));
	}

	Filter<Npc> yOrb = new Filter<Npc>() {
		public boolean accept(Npc m) {
			return m.getId() == 8021
					&& Calculations.distanceTo(m.getLocation()) > 3;
		}
	};

	Filter<Npc> gOrb = new Filter<Npc>() {
		public boolean accept(Npc n) {
			return n.getId() == 8025
					&& Calculations.distanceTo(n.getLocation()) > 3;
		}
	};
	Rectangle closeButton = new Rectangle(498, 357, 25, 25);// <<<Change x and y
															// to the coordiante
															// of the button.
	Point p;
	boolean showPaint = true;
	Color buttonColor = new Color(255, 0, 50);
	Color black = new Color(0, 0, 0);
	BasicStroke stroke1 = new BasicStroke(1);
	private final RenderingHints antialiasing = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	private Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			return null;
		}
	}

	private final Color color1 = new Color(255, 255, 204);
	private final Color color2 = new Color(102, 255, 102);
	private final Color color3 = new Color(51, 51, 0);
	private final Color color4 = new Color(0, 51, 51);

	private final Font font1 = new Font("Copperplate Gothic Bold", 1, 30);
	private final Font font2 = new Font("Copperplate Gothic Bold", 1, 15);
	private final Font font3 = new Font("Calibri", 1, 20);

	private final Image img1 = getImage("http://images4.wikia.nocookie.net/__cb20100320123411/runescape/images/1/12/Green_orb.png");
	private final Image img2 = getImage("http://images3.wikia.nocookie.net/__cb20100320122952/runescape/images/thumb/a/a1/Yellow_orb.png/100px-Yellow_orb.png");

	public void onRepaint(Graphics g1) {
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHints(antialiasing);
		int topRightX = closeButton.x + 25;
		int topRightY = closeButton.y + 25;
		int bottomRightX = closeButton.x + 25;
		int topLeftY = closeButton.y + 25;
		int bottomLeftX5 = closeButton.x + 5;
		int bottomLeftY5 = closeButton.y + 5;
		g.setColor(buttonColor);
		g.fillRect(closeButton.x, closeButton.y, closeButton.width,
				closeButton.height);// <<Fills a rectangle
		g.setColor(black);
		g.setStroke(stroke1);
		g.drawRect(closeButton.x, closeButton.y, closeButton.width,
				closeButton.height);// <<<Draws a black outline around the close
									// button
		if (showPaint) {
			g.drawLine(closeButton.x, closeButton.y, topRightX, topRightY);
			g.drawLine(bottomRightX, closeButton.height, closeButton.x,
					topLeftY);
			g.setColor(color1);
			g.fillRect(0, 339, 517, 139);
			g.drawImage(img1, 16, 376, null);
			g.drawImage(img2, 408, 358, null);
			g.setFont(font1);
			g.setColor(color2);
			g.drawString("JustSoProGOP", 100, 365);
			g.setFont(font2);
			g.setColor(color3);
			g.drawString("Getting you tokens like no other", 83, 379);
			g.setFont(font3);
			g.setColor(color4);
			g.drawString("Runtime:" + RUN_TIME.toElapsedString(), 150, 400);
			g.drawString("Tokens Gained:" + ((CURRENT_TOKENS - START_TOKENS)),
					150, 425);
			g.drawString(
					"Tokens/Hour:"
							+ ((CURRENT_TOKENS - START_TOKENS) * 3600000D)
							/ RUN_TIME.getElapsed(), 150, 450);
			g.drawImage(img1, 16, 376, null);
		} else {
			g.drawRect(bottomLeftX5, bottomLeftY5, 15, 15);
		}
	}

	@Override
	public void onFinish() {
		log("Thank you for using JustSoProGOP!");
	}

	@Override
	public boolean onStart() {

		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					gui = new Gui();
					gui.setVisible(true);
				}
			});
		} catch (InterruptedException e) {
		} catch (InvocationTargetException e) {
		}
		while (gui.isVisible()) {
			sleep(50);
		}

		START_TOKENS = Inventory.getCount(true, TOKENS);
		RUN_TIME = new Timer(0);
		log("JustSoProGOP has started!");
		return true;
	}

	public State getState() {
		if (playerInArea(GUILD_AREA)) {
			return State.join;
		}
		Npc exitPortal = Npcs.getNearest(new int[] { 8020 });
		GameObject alter;
		alter = Objects.getNearest(AIR_ALTER_ID);
		if (alter != null) {
			if (Calculations.distanceTo(alter.getLocation()) < 100
					&& SCORE == true && Inventory.getCount(ESS) < 5
					&& exitPortal == null) {
				return State.offend;
			}
		}
		alter = Objects.getNearest(MIND_ALTER_ID);
		if (alter != null) {
			if (Calculations.distanceTo(alter.getLocation()) < 100
					&& SCORE == true && Inventory.getCount(ESS) < 5
					&& exitPortal == null) {
				return State.offend;
			}
		}
		alter = Objects.getNearest(WATER_ALTER_ID);
		if (alter != null) {
			if (Calculations.distanceTo(alter.getLocation()) < 100
					&& SCORE == true && Inventory.getCount(ESS) < 5
					&& exitPortal == null) {
				return State.offend;
			}
		}
		alter = Objects.getNearest(EARTH_ALTER_ID);
		if (alter != null) {
			if (Calculations.distanceTo(alter.getLocation()) < 100
					&& SCORE == true && Inventory.getCount(ESS) < 5
					&& exitPortal == null) {
				return State.offend;
			}
		}
		alter = Objects.getNearest(FIRE_ALTER_ID);
		if (alter != null) {
			if (Calculations.distanceTo(alter.getLocation()) < 100
					&& SCORE == true && Inventory.getCount(ESS) < 5
					&& exitPortal == null) {
				return State.offend;
			}
		}
		alter = Objects.getNearest(BODY_ALTER_ID);
		if (alter != null) {
			if (Calculations.distanceTo(alter.getLocation()) < 100
					&& SCORE == true && Inventory.getCount(ESS) < 5
					&& exitPortal == null) {
				return State.offend;
			}
		}
		alter = Objects.getNearest(AIR_ALTER_ID);
		if (alter != null) {
			if (Calculations.distanceTo(alter.getLocation()) < 100
					&& SCORE == false && Inventory.getCount(ESS) < 5
					&& exitPortal == null) {
				return State.defend;
			}
		}
		alter = Objects.getNearest(MIND_ALTER_ID);
		if (alter != null) {
			if (Calculations.distanceTo(alter.getLocation()) < 100
					&& SCORE == false && Inventory.getCount(ESS) < 5
					&& exitPortal == null) {
				return State.defend;
			}
		}
		alter = Objects.getNearest(WATER_ALTER_ID);
		if (alter != null) {
			if (Calculations.distanceTo(alter.getLocation()) < 100
					&& SCORE == false && Inventory.getCount(ESS) < 5
					&& exitPortal == null) {
				return State.defend;
			}
		}
		alter = Objects.getNearest(EARTH_ALTER_ID);
		if (alter != null) {
			if (Calculations.distanceTo(alter.getLocation()) < 100
					&& SCORE == false && Inventory.getCount(ESS) < 5
					&& exitPortal == null) {
				return State.defend;
			}
		}
		alter = Objects.getNearest(FIRE_ALTER_ID);
		if (alter != null) {
			if (Calculations.distanceTo(alter.getLocation()) < 100
					&& SCORE == false && Inventory.getCount(ESS) < 5
					&& exitPortal == null) {
				return State.defend;
			}
		}
		alter = Objects.getNearest(BODY_ALTER_ID);
		if (alter != null) {
			if (Calculations.distanceTo(alter.getLocation()) < 100
					&& SCORE == false && Inventory.getCount(ESS) < 5
					&& exitPortal == null) {
				return State.defend;
			}
		}
		if (Inventory.getCount(ESS) >= 5) {
			return State.craftRunes;
		}
		if (Inventory.getCount(ESS) < 5 && exitPortal != null) {
			return State.exit;
		}
		return State.error;
	}

	public boolean playerInArea(int[] area) {
		int x = Players.getLocal().getLocation().getX();
		int y = Players.getLocal().getLocation().getY();
		if (x >= area[0] && y >= area[1] && x <= area[2] && y <= area[3])
			return true;
		return false;
	}
}