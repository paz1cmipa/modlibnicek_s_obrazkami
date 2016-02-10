
package GUI;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import Entity.Citat;
import Entity.Modlitba;
import InterfacesMysqlobjectOther.MysqlAutor;
import InterfacesMysqlobjectOther.MysqlCitat;
import InterfacesMysqlobjectOther.MysqlModlitba;
import Entity.Oblubene;
import Entity.SrdcovyBonus;
import InterfacesMysqlobjectOther.Sviatok;
import InterfacesMysqlobjectOther.MysqlBonus;
import InterfacesMysqlobjectOther.MysqlUmysel;


public class MainForm extends javax.swing.JFrame {

   private Citat citat;
   private Modlitba mod = null;
   private Oblubene ob = new Oblubene();
   private int informacia = 0; // Co chcem pridat medzi favorite? (1->M,2->C)
   private MysqlUmysel zoznamUm = new MysqlUmysel();
   private int pocitadlo = 0;
   private int pocitadlo2 = 0;
   private int fvtVisible = 1;
   private ImageIcon aktualny = new javax.swing.ImageIcon("Cross-Easter.jpg");       
   private int sviatok = 0;
   private Kniha k = new Kniha(this);
   int den = 0;
   int mesiac = 0;
   private Sviatok sv = new Sviatok();
    public MainForm() {
        initComponents();
        
                MysqlModlitba zoznam = new MysqlModlitba();
		zoznam.dajVsetky();

		Object[] elements = zoznam.dajVsetky().toArray();
		AutoCompleteSupport.install(nazovField, GlazedLists.eventListOf(elements));

		choice1.addItem("Všetky");
		choice1.addItem("Z Biblie");
		choice1.addItem("Citáty svätcov");
		choice1.addItem("Obrázkový citát");

		fvtChoice.addItem("Modlitby");
		fvtChoice.addItem("Citáty");

		Calendar mCalendar = Calendar.getInstance();
		den = mCalendar.get(Calendar.DAY_OF_MONTH);
		mesiac = mCalendar.get(Calendar.MONTH) + 1;
		sviatok = mesiac - 1;
		sviatokLable.setText(sv.nacitaj(mesiac, den));

		pozadie.setIcon(aktualny);
		getContentPane().add(pozadie, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -30, 1000, 590));

		getContentPane().setBackground(new Color(54, 58, 55));
		this.setSize(887, 600);
		this.setTitle("Modlibníček");
		Image im = Toolkit.getDefaultToolkit().getImage("aa.jpg");
		this.setIconImage(im);
		setLocation(new java.awt.Point(500, 200));

		final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		ActionListener timerListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = new Date();
				String time = timeFormat.format(date);
				String vysl = den + ". " + mesiac + ", " + time;
				casLable.setText(vysl);
			}
		};
		Timer timer = new Timer(1000, timerListener);
		timer.setInitialDelay(0);
		timer.start();

		this.setResizable(false);
		zoznamList.setVisible(false);
		zivotopisButton.setVisible(false);
		zaKohoButton.setVisible(false);
		modlimSaZaLable.setVisible(false);
		pridajButton.setVisible(false);
		choice1.setVisible(false);
		uvodzovkaL1.setVisible(false);
		uvodzovkaL2.setVisible(false);
		menoLable.setVisible(false);
		laskaButton.setVisible(false);
		downButton.setVisible(false);
		fvtButton.setVisible(false);
		sviatokLable.setVisible(false);
		pasik.setVisible(false);
		//doplnokL.setVisible(false);
		pridajAbutton.setVisible(false);
       

    
     
    }
    
    public void setPozadie(ImageIcon imageIcon){
        pozadie.setIcon(imageIcon);
    }
    
    public void setAktualny(ImageIcon icon){
        aktualny = icon;
    }
    
     public void setFont(Font f){
         
        textBox.setFont(f);
        
         
     }
     
     public int getVfont(){
         
      return textBox.getFont().getSize();
     }
     
     private void goWebsite(JLabel website, final String url, String text) {
        website.setText("<html> Website : <a href=\"\">"+text+"</a></html>");
        website.setCursor(new Cursor(Cursor.HAND_CURSOR));
        website.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                    try {
                            Desktop.getDesktop().browse(new URI(url));
                    } catch (URISyntaxException | IOException ex) {
                            //It looks like there's a problem
                    }
            }
        });
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        najstButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textBox = new javax.swing.JTextArea();
        citatButton = new javax.swing.JToggleButton();
        zivotopisButton = new javax.swing.JButton();
        zaKohoButton = new javax.swing.JButton();
        modlimSaZaLable = new javax.swing.JLabel();
        pridajButton = new javax.swing.JButton();
        domovButton = new javax.swing.JButton();
        PRIDAJbutton = new javax.swing.JButton();
        pribehButton = new javax.swing.JButton();
        nastaveniaButton = new javax.swing.JButton();
        pozadie = new javax.swing.JLabel();
        choice1 = new java.awt.Choice();
        uvodzovkaL1 = new javax.swing.JLabel();
        uvodzovkaL2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        zoznamList = new javax.swing.JList();
        sipkaButton = new javax.swing.JButton();
        odstranButton = new javax.swing.JButton();
        nazovField = new javax.swing.JComboBox();
        menoLable = new javax.swing.JLabel();
        laskaButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        fvtList = new javax.swing.JList();
        zobrazFvtButton = new javax.swing.JButton();
        zobrazitButton = new javax.swing.JButton();
        fvtChoice = new java.awt.Choice();
        fvtButton = new javax.swing.JButton();
        binButton = new javax.swing.JButton();
        pozadieFvt = new javax.swing.JLabel();
        sviatokLable = new javax.swing.JLabel();
        pasik = new javax.swing.JLabel();
        casLable = new javax.swing.JLabel();
        pridajAbutton = new javax.swing.JButton();
        pravdyVieryButton = new javax.swing.JButton();
        hladajTextField = new javax.swing.JTextField();
        hladatButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 0, 51));
        setLocation(new java.awt.Point(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        najstButton.setBackground(new java.awt.Color(204, 255, 255));
        najstButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        najstButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/najstM.jpg"))); // NOI18N
        najstButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                najstButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                najstButtonMouseExited(evt);
            }
        });
        najstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                najstButtonActionPerformed(evt);
            }
        });
        getContentPane().add(najstButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 160, 40));

        textBox.setEditable(false);
        textBox.setColumns(20);
        textBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        textBox.setRows(5);
        jScrollPane1.setViewportView(textBox);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 680, 330));

        citatButton.setBackground(new java.awt.Color(204, 255, 255));
        citatButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        citatButton.setText("citát :)");
        citatButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                citatButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                citatButtonMouseExited(evt);
            }
        });
        citatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citatButtonActionPerformed(evt);
            }
        });
        getContentPane().add(citatButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 115, 37));

        zivotopisButton.setBackground(new java.awt.Color(204, 255, 255));
        zivotopisButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        zivotopisButton.setText("O autorovi");
        zivotopisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zivotopisButtonActionPerformed(evt);
            }
        });
        getContentPane().add(zivotopisButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 38));

        zaKohoButton.setBackground(new java.awt.Color(204, 255, 255));
        zaKohoButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        zaKohoButton.setText("? Za koho sa modlím ?");
        zaKohoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zaKohoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(zaKohoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        modlimSaZaLable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        modlimSaZaLable.setForeground(new java.awt.Color(255, 255, 255));
        modlimSaZaLable.setText("Modlím sa za:");
        getContentPane().add(modlimSaZaLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 130, 67));

        pridajButton.setBackground(new java.awt.Color(204, 255, 255));
        pridajButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pridajButton.setText("Pridaj úmysel");
        pridajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pridajButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        domovButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/1a.jpg"))); // NOI18N
        domovButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                domovButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                domovButtonMouseExited(evt);
            }
        });
        domovButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domovButtonActionPerformed(evt);
            }
        });
        getContentPane().add(domovButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 80, 70));

        PRIDAJbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/n.jpg"))); // NOI18N
        PRIDAJbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PRIDAJbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PRIDAJbuttonMouseExited(evt);
            }
        });
        PRIDAJbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRIDAJbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(PRIDAJbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 100, 70));

        pribehButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/k2.jpg"))); // NOI18N
        pribehButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pribehButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pribehButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pribehButtonMouseExited(evt);
            }
        });
        pribehButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pribehButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pribehButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 100, 70));

        nastaveniaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/s1a.jpg"))); // NOI18N
        nastaveniaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nastaveniaButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nastaveniaButtonMouseExited(evt);
            }
        });
        nastaveniaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nastaveniaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nastaveniaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, 80, 80));
        getContentPane().add(pozadie, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 10));
        getContentPane().add(choice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, 120, 30));
        getContentPane().add(uvodzovkaL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 40, 20));
        getContentPane().add(uvodzovkaL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, -1, 30));

        zoznamList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        zoznamList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zoznamListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(zoznamList);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 260, 510));

        sipkaButton.setBackground(new java.awt.Color(153, 153, 255));
        sipkaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/arr.jpg"))); // NOI18N
        sipkaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sipkaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sipkaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 243, 50, 50));

        odstranButton.setBackground(new java.awt.Color(204, 204, 204));
        odstranButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        odstranButton.setText("Odstraniť");
        odstranButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odstranButtonActionPerformed(evt);
            }
        });
        getContentPane().add(odstranButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 510, 210, 50));

        nazovField.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        nazovField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nazovFieldActionPerformed(evt);
            }
        });
        getContentPane().add(nazovField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 250, 40));

        menoLable.setFont(new java.awt.Font("AR DECODE", 1, 45)); // NOI18N
        menoLable.setForeground(new java.awt.Color(153, 0, 102));
        menoLable.setText("menoumy sel");
        getContentPane().add(menoLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 210, 40));

        laskaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/12520369_1236292979719721_1379009942_n.gif"))); // NOI18N
        laskaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laskaButtonActionPerformed(evt);
            }
        });
        getContentPane().add(laskaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 70, 70));

        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/down.jpg"))); // NOI18N
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });
        getContentPane().add(downButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 70, 60));

        fvtList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        fvtList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fvtListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(fvtList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 600, 680, 240));

        zobrazFvtButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/fav1.jpg"))); // NOI18N
        zobrazFvtButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                zobrazFvtButtonMouseEntered(evt);
            }
        });
        zobrazFvtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zobrazFvtButtonActionPerformed(evt);
            }
        });
        getContentPane().add(zobrazFvtButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 510, 50, 50));

        zobrazitButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        zobrazitButton.setText("Zobraziť");
        zobrazitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zobrazitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(zobrazitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 710, -1, -1));
        getContentPane().add(fvtChoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 670, 150, 30));

        fvtButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/Folder-Blue-Favorite-icon.jpg"))); // NOI18N
        fvtButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fvtButtonMouseEntered(evt);
            }
        });
        fvtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fvtButtonActionPerformed(evt);
            }
        });
        getContentPane().add(fvtButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 80, 80));

        binButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/bin1.jpg"))); // NOI18N
        binButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                binButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                binButtonMouseExited(evt);
            }
        });
        binButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binButtonActionPerformed(evt);
            }
        });
        getContentPane().add(binButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 770, 60, 60));

        pozadieFvt.setBackground(new java.awt.Color(153, 153, 255));
        pozadieFvt.setForeground(new java.awt.Color(153, 153, 255));
        pozadieFvt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/hv.jpg"))); // NOI18N
        getContentPane().add(pozadieFvt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 1150, 310));

        sviatokLable.setFont(new java.awt.Font("Gabriola", 1, 24)); // NOI18N
        sviatokLable.setForeground(new java.awt.Color(255, 255, 255));
        sviatokLable.setText("meno sv.");
        sviatokLable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sviatokLableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sviatokLableMouseEntered(evt);
            }
        });
        getContentPane().add(sviatokLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 290, -1));

        pasik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pasikMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pasikMouseExited(evt);
            }
        });
        getContentPane().add(pasik, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 330, 50));

        casLable.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        casLable.setForeground(new java.awt.Color(255, 255, 255));
        casLable.setText("cas");
        getContentPane().add(casLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 270, 30));

        pridajAbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajAbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(pridajAbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 50, 50));

        pravdyVieryButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pravdyVieryButton.setText("Pravdy kresťanskej viery");
        pravdyVieryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pravdyVieryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(pravdyVieryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 250, -1));
        getContentPane().add(hladajTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 140, 30));

        hladatButton.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        hladatButton.setText("Hľadaj");
        hladatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hladatButtonActionPerformed(evt);
            }
        });
        getContentPane().add(hladatButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
   @SuppressWarnings("empty-statement")
    private void najstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_najstButtonActionPerformed

         pocitadlo2++;
         
        if (pocitadlo2 % 12 == 0) {
			laskaButton.setVisible(true);
		}
        
        
                textBox.setText(null);
		modlimSaZaLable.setVisible(false);
		zivotopisButton.setVisible(false);
		downButton.setVisible(false);
		fvtButton.setVisible(false);

		String zadane = new String();
		if (nazovField.getSelectedItem() == null) {

			ImageIcon icon = new ImageIcon("oops.jpg");
			JOptionPane.showMessageDialog(null, "Zadajte názov modlitby!", "Modlibníček info",
					JOptionPane.INFORMATION_MESSAGE, icon);
			return;
		} else {
			zadane = nazovField.getSelectedItem().toString();
		}

		MysqlModlitba zoznamD = new MysqlModlitba();

		if (zoznamD.contains(zadane)) {
			mod = zoznamD.dajModlitbu(zadane);

			pridajButton.setVisible(true);
			zaKohoButton.setVisible(true);

			textBox.setText(mod.getText());
			if (!(ob.constainM(mod))) {
				fvtButton.setVisible(true);
				informacia = 1;
			}

		} else {

			ImageIcon icon = new ImageIcon("oops.jpg");
			JOptionPane
					.showMessageDialog(null,
							"Modlitba sa nenachádza v zozname." + "\n" + "Pridajte novú Modlitbu s takýmto názvom "
									+ "\n" + "alebo si vyberte zo zoznamu",
							"Modlibníček info", JOptionPane.INFORMATION_MESSAGE, icon);
			this.sipkaButtonActionPerformed(evt);

		}

		pozadie.setIcon(aktualny);
        
    }//GEN-LAST:event_najstButtonActionPerformed

    
    private void citatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citatButtonActionPerformed

       pocitadlo2++;

		menoLable.setVisible(false);
		modlimSaZaLable.setVisible(false);
		zaKohoButton.setVisible(false);
		pridajButton.setVisible(false);
		downButton.setVisible(true);
		downButton.setEnabled(false);
                fvtButton.setVisible(false);
                zivotopisButton.setEnabled(false);
                pridajAbutton.setVisible(false);


		choice1.setVisible(true);

		MysqlCitat zoznam = new MysqlCitat();

		if (pocitadlo2 % 12 == 0) {
			laskaButton.setVisible(true);
		}


		if (choice1.getSelectedItem().equals("Z Biblie")) {

			citat = zoznam.dajNahodnyBiblickyCitat();
			String cit = citat.toString() + "\n" + citat.getAutor();

			textBox.setText(cit);
                        informacia = 2;
                       if(!(ob.constainC(citat))){ 
                        fvtButton.setVisible(true);
                        informacia = 2;
                       }
                        
			return;
		}
		if (choice1.getSelectedItem().equals("Obrázkový citát")) {

			downButton.setEnabled(true);
			ObrazkovyCitat obr = new ObrazkovyCitat();
			obr.setVisible(true);
                        
                        fvtButton.setVisible(true);
                        informacia = 2;
                        
			return;
		}
                
                MysqlAutor ma = new MysqlAutor();
                
                if (choice1.getSelectedItem().equals("Citáty svätcov")) {

			citat = zoznam.dajNahodnyNebiblickyCitat();
			String cit = citat.toString() + "\n" + citat.getAutor();

			textBox.setText(cit);
			if(ma.contains(citat.getAutor())){
                            
                      zivotopisButton.setVisible(true);
                      zivotopisButton.setEnabled(true);
                  }else{
                          pridajAbutton.setVisible(true);
                            
                        }
                        fvtButton.setVisible(true);
                        informacia = 2;

			return;
		} 

		if (choice1.getSelectedItem().equals("Všetky")) {

                    citat = zoznam.dajNahodnyCitat();
                    
                    if(citat.jeBiblicky()){
                        
                    }else{
                  if(ma.contains(citat.getAutor())){
                      zivotopisButton.setVisible(true);
                      zivotopisButton.setEnabled(true);
                  }else{
                  
                      pridajAbutton.setVisible(true);
                  } 
                    }
                        
			String cit = citat.toString() + "\n" + citat.getAutor();

			textBox.setText(cit);
                        
                        fvtButton.setVisible(true);
                        informacia = 2;

			return;

		}

		pozadie.setIcon(aktualny);
	


      
      
      
      

    }//GEN-LAST:event_citatButtonActionPerformed

    private void zivotopisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zivotopisButtonActionPerformed

        pocitadlo2++;
        
        if (pocitadlo2 % 12 == 0) {
			laskaButton.setVisible(true);
		}
        modlimSaZaLable.setVisible(false);
        
        MysqlAutor ma = new MysqlAutor();
        String zivotopis = ma.dajAutora(citat.getAutor()).getzivotopis();
        
        textBox.setText(zivotopis);
    }//GEN-LAST:event_zivotopisButtonActionPerformed

    private void zaKohoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zaKohoButtonActionPerformed

        fvtButton.setVisible(false);
        najstButton.setVisible(false);
        nazovField.setVisible(false);
        menoLable.setVisible(true);
        modlimSaZaLable.setVisible(true);
       
       
        menoLable.setText(zoznamUm.dajNahodny().toString());
    }//GEN-LAST:event_zaKohoButtonActionPerformed

    private void pridajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajButtonActionPerformed

        
        pocitadlo2++;
        
  
        pridajUmyselForm az = new pridajUmyselForm();
        az.setVisible(true);
        
    }//GEN-LAST:event_pridajButtonActionPerformed

    private void domovButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domovButtonActionPerformed
           
        
        if(pocitadlo % 2 != 0){
            this.sipkaButtonActionPerformed(evt);
        }

           pozadie.setIcon(aktualny); 
           getContentPane().add(pozadie, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -30, 1000, 590));
           menoLable.setVisible(false);
           najstButton.setVisible(true);
           zivotopisButton.setVisible(false);
           zaKohoButton.setVisible(false);
           fvtButton.setVisible(false);
           
          modlimSaZaLable.setVisible(false);
          pridajButton.setVisible(false);
          downButton.setVisible(false);
          textBox.setText(null);
          choice1.setVisible(false);
          nazovField.setVisible(true);
          pridajAbutton.setVisible(false);
          
  
          
          
          
    }//GEN-LAST:event_domovButtonActionPerformed

    private void PRIDAJbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRIDAJbuttonActionPerformed
        
         pocitadlo2++;
        
        fvtButton.setVisible(false);
        downButton.setVisible(false);
        PridajteForm pf = new PridajteForm();
        pf.setVisible(true);
        pozadie.setIcon(aktualny);
        
    }//GEN-LAST:event_PRIDAJbuttonActionPerformed

    private void pribehButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pribehButtonActionPerformed
        
        
                   
        fvtButton.setVisible(false);
        this.setVisible(false);
        Kniha k = new Kniha(this);
        Point location = this.getLocation();
        k.setLocation(location);
        k.setVisible(true);
        
         pozadie.setIcon(aktualny);
        
    }//GEN-LAST:event_pribehButtonActionPerformed

    private void pribehButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pribehButtonMouseClicked
        
       
    }//GEN-LAST:event_pribehButtonMouseClicked

    private void pribehButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pribehButtonMouseEntered
        pribehButton.setIcon(new javax.swing.ImageIcon("k3.jpg"));
        pribehButton.setToolTipText("Knižný mód");
    }//GEN-LAST:event_pribehButtonMouseEntered

    private void pribehButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pribehButtonMouseExited
         pribehButton.setIcon(new javax.swing.ImageIcon("k2.jpg"));
    }//GEN-LAST:event_pribehButtonMouseExited

    private void najstButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_najstButtonMouseEntered
      najstButton.setIcon(new javax.swing.ImageIcon("najstMk.jpg"));
    }//GEN-LAST:event_najstButtonMouseEntered

    private void najstButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_najstButtonMouseExited
      najstButton.setIcon(new javax.swing.ImageIcon("najstM.jpg")); 
    }//GEN-LAST:event_najstButtonMouseExited

    private void domovButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_domovButtonMouseEntered
        domovButton.setToolTipText("Domov");
        domovButton.setIcon(new javax.swing.ImageIcon("2a.jpg"));
    }//GEN-LAST:event_domovButtonMouseEntered

    private void domovButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_domovButtonMouseExited
    domovButton.setIcon(new javax.swing.ImageIcon("1a.jpg"));
    }//GEN-LAST:event_domovButtonMouseExited

    private void nastaveniaButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nastaveniaButtonMouseEntered
        nastaveniaButton.setIcon(new javax.swing.ImageIcon("setting2.jpg"));
        nastaveniaButton.setToolTipText("Nastavvenia");
    }//GEN-LAST:event_nastaveniaButtonMouseEntered

    private void nastaveniaButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nastaveniaButtonMouseExited
        nastaveniaButton.setIcon(new javax.swing.ImageIcon("s1a.jpg"));
    }//GEN-LAST:event_nastaveniaButtonMouseExited

    private void nastaveniaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nastaveniaButtonActionPerformed
       
        NastavenieForm nf = new NastavenieForm(this,true);
       
        nf.setVisible(true);
    }//GEN-LAST:event_nastaveniaButtonActionPerformed

    private void citatButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_citatButtonMouseEntered
      
           uvodzovkaL1.setVisible(true);
           uvodzovkaL2.setVisible(true);
       
    }//GEN-LAST:event_citatButtonMouseEntered

    private void citatButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_citatButtonMouseExited
             uvodzovkaL1.setVisible(false);
             uvodzovkaL2.setVisible(false);
    }//GEN-LAST:event_citatButtonMouseExited

    private void PRIDAJbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRIDAJbuttonMouseEntered
      
        PRIDAJbutton.setIcon(new javax.swing.ImageIcon("n2.jpg"));
        PRIDAJbutton.setToolTipText("Pridať..");
    }//GEN-LAST:event_PRIDAJbuttonMouseEntered

    private void PRIDAJbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRIDAJbuttonMouseExited
        PRIDAJbutton.setIcon(new javax.swing.ImageIcon("n.jpg"));

    }//GEN-LAST:event_PRIDAJbuttonMouseExited

    private void sipkaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sipkaButtonActionPerformed

    
        zivotopisButton.setVisible(false);
        MysqlModlitba zm = new MysqlModlitba();
        
        List<Modlitba> list = zm.dajVsetky();
        zoznamList.setListData(list.toArray());
        pocitadlo++;
        
        if(pocitadlo % 2==0){
         zoznamList.setVisible(false);  
         this.setSize(887, 600);
         sipkaButton.setIcon(new javax.swing.ImageIcon("arr.jpg"));

        }else{
           this.setSize(1145, 600); 
           zoznamList.setVisible(true);
           sipkaButton.setIcon(new javax.swing.ImageIcon("arr2.jpg"));
        }
    }//GEN-LAST:event_sipkaButtonActionPerformed

    private void odstranButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odstranButtonActionPerformed
        
        MysqlModlitba zm = new MysqlModlitba();
        Modlitba modlitba = zm.dajModlitbu(zoznamList.getSelectedValue().toString());
        zm.odstranit(modlitba);
        zoznamList.setListData(zm.dajVsetky().toArray());
    }//GEN-LAST:event_odstranButtonActionPerformed

    private void nazovFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nazovFieldActionPerformed
    
        
    }//GEN-LAST:event_nazovFieldActionPerformed

    private void laskaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laskaButtonActionPerformed
    
         laskaButton.setToolTipText("Srdiečkový bonus");
         zivotopisButton.setVisible(false);
         laskaButton.setVisible(false);
         pozadie.setIcon(new javax.swing.ImageIcon("love3.jpg"));
         getContentPane().add(pozadie, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -30, 1000, 590));
         fvtButton.setVisible(false);
         
         MysqlBonus mb = new MysqlBonus();
         SrdcovyBonus sb = mb.nahodneVyber();
         textBox.setText(sb.toString());

    }//GEN-LAST:event_laskaButtonActionPerformed

    private void zoznamListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zoznamListMouseClicked

        	if (evt.getClickCount() == 2) {

			fvtButton.setVisible(false);

			informacia = 1;

			MysqlModlitba zm = new MysqlModlitba();

			mod = zm.dajModlitbu(zoznamList.getSelectedValue().toString());

			if (!(ob.constainM(mod))) {
				fvtButton.setVisible(true);
			}
			textBox.setText(mod.getText());
		}

    }//GEN-LAST:event_zoznamListMouseClicked

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed

        JFileChooser fs = new JFileChooser();
        BufferedImage fg = new BufferedImage(WIDTH, WIDTH, WIDTH);
        

    if (fs.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {

        File fi = fs.getSelectedFile();
            try {
               
                String test = fi.getAbsolutePath();
                ImageIO.write((BufferedImage)fg,"png",new File("Cross-Easter.jpg"));
                ImageIO.write(fg, "png", fs.getSelectedFile());
            
            } catch (IOException ex) {
                
            }
}


    }//GEN-LAST:event_downButtonActionPerformed

    private void zobrazFvtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zobrazFvtButtonActionPerformed

        if(!(fvtVisible % 2 ==0)){
        this.setSize(1145, 900);
        
        fvtList.setListData(ob.vypisM().toArray());
        informacia = -1;
        fvtVisible++;
    } else {
            
       this.setSize(1145, 600); 
       fvtVisible++;

        }
      
        
    }//GEN-LAST:event_zobrazFvtButtonActionPerformed

    private void zobrazitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zobrazitButtonActionPerformed

        if(fvtChoice.getSelectedItem().equals("Modlitby")){
        
            fvtList.setListData(ob.vypisM().toArray());
            informacia = -1;  //
        }
        
        if(fvtChoice.getSelectedItem().equals("Citáty")){
        
            fvtList.setListData(ob.vypisC().toArray());
            informacia = -2; // 
            
        }

    }//GEN-LAST:event_zobrazitButtonActionPerformed

    private void fvtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fvtButtonActionPerformed
        
        ImageIcon icon = new ImageIcon("favorite-child.jpg");
                JOptionPane.showMessageDialog(
                        null,
                        "Položka bola úspešne uložená medzi obľúbené :)",
                        "Modlibniček info", JOptionPane.INFORMATION_MESSAGE,
                        icon);
                fvtButton.setVisible(false);
        
        if(informacia == 1 && !(ob.constainM(mod))){
        ob.pridajModlitbu(mod);
        fvtList.setListData(ob.vypisM().toArray());
        informacia = -1;
        } 
        
        if(informacia == 2 && !(ob.constainC(citat))) {
        ob.pridajCitat(citat);
        fvtList.setListData(ob.vypisC().toArray());
        informacia = -2;

        }
        
         
    }//GEN-LAST:event_fvtButtonActionPerformed

    private void fvtListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fvtListMouseClicked
                    
        if(evt.getClickCount() == 2){ 
        MysqlModlitba zm = new MysqlModlitba();

        Modlitba modlitba = zm.dajModlitbu(fvtList.getSelectedValue().toString());
                
        textBox.setText(modlitba.getText());
        
        }
    }//GEN-LAST:event_fvtListMouseClicked

    private void binButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binButtonActionPerformed

        
        if(informacia == -1){
            Modlitba  m = (Modlitba) fvtList.getSelectedValue();
            ob.odstranM(m);
            fvtList.setListData(ob.vypisM().toArray());
            return;
        }
        
         if(informacia == -2){
            Citat cit = (Citat) fvtList.getSelectedValue();
            ob.odstranC(cit);
            fvtList.setListData(ob.vypisC().toArray());
        }

    }//GEN-LAST:event_binButtonActionPerformed

    private void fvtButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fvtButtonMouseEntered

        fvtButton.setToolTipText("Pridať medzi obľubené");
    }//GEN-LAST:event_fvtButtonMouseEntered

    private void pasikMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pasikMouseEntered
        
        pasik.setVisible(true);
        sviatokLable.setVisible(true);
//        doplnokL.setVisible(true);
    }//GEN-LAST:event_pasikMouseEntered

    private void pasikMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pasikMouseExited
        
        pasik.setVisible(false);
        sviatokLable.setVisible(false);
     //   doplnokL.setVisible(false);
        
         sviatokLable.setText(sv.nacitaj(mesiac, den));
        
        
    }//GEN-LAST:event_pasikMouseExited

    private void sviatokLableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sviatokLableMouseClicked
        
        String[] mesiace = {"januar","februar","marec","april","maj","jun","jul","august","september","oktober","november","december"};
        
        this.goWebsite(sviatokLable, "http://www.zivotopisysvatych.sk/zoznam-podla-datumu/" + mesiace[sviatok], "najsť životopis");
        System.out.println(sviatok);
    }//GEN-LAST:event_sviatokLableMouseClicked

    private void sviatokLableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sviatokLableMouseEntered
         
         sviatokLable.setVisible(true);
         pasik.setVisible(true);/*
         doplnokL.setVisible(true);    }//GEN-LAST:event_sviatokLableMouseEntered
*/
    }
    private void zobrazFvtButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zobrazFvtButtonMouseEntered

        zobrazFvtButton.setToolTipText("Obľúbené položky");
        // TODO add your handling code here:
    }//GEN-LAST:event_zobrazFvtButtonMouseEntered

    private void pridajAbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajAbuttonActionPerformed
        
        PridajAform pa = new PridajAform(citat.getAutor());
        pa.setVisible(true);
    }//GEN-LAST:event_pridajAbuttonActionPerformed

    private void binButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_binButtonMouseEntered
                
        if(!(fvtList.isSelectionEmpty())){
              binButton.setIcon(new javax.swing.ImageIcon("bin2.jpg"));
        }
    }//GEN-LAST:event_binButtonMouseEntered

    private void binButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_binButtonMouseExited
        
         binButton.setIcon(new javax.swing.ImageIcon("bin1.jpg"));
         
    }//GEN-LAST:event_binButtonMouseExited

    private void pravdyVieryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pravdyVieryButtonActionPerformed
          PravdyVieryForm pravdy = new PravdyVieryForm(this, true);
          pravdy.setVisible(true);
    }//GEN-LAST:event_pravdyVieryButtonActionPerformed

    private void hladatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hladatButtonActionPerformed
       String slovo = hladajTextField.getText();
       HladajForm hladaj = new HladajForm(this, true, slovo);
       hladaj.setVisible(true);
    }//GEN-LAST:event_hladatButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new MainForm().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PRIDAJbutton;
    private javax.swing.JButton binButton;
    private javax.swing.JLabel casLable;
    private java.awt.Choice choice1;
    private javax.swing.JToggleButton citatButton;
    private javax.swing.JButton domovButton;
    private javax.swing.JButton downButton;
    private javax.swing.JButton fvtButton;
    private java.awt.Choice fvtChoice;
    private javax.swing.JList fvtList;
    private javax.swing.JTextField hladajTextField;
    private javax.swing.JButton hladatButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton laskaButton;
    private javax.swing.JLabel menoLable;
    private javax.swing.JLabel modlimSaZaLable;
    private javax.swing.JButton najstButton;
    private javax.swing.JButton nastaveniaButton;
    private javax.swing.JComboBox nazovField;
    private javax.swing.JButton odstranButton;
    private javax.swing.JLabel pasik;
    private javax.swing.JLabel pozadie;
    private javax.swing.JLabel pozadieFvt;
    private javax.swing.JButton pravdyVieryButton;
    private javax.swing.JButton pribehButton;
    private javax.swing.JButton pridajAbutton;
    private javax.swing.JButton pridajButton;
    private javax.swing.JButton sipkaButton;
    private javax.swing.JLabel sviatokLable;
    private javax.swing.JTextArea textBox;
    private javax.swing.JLabel uvodzovkaL1;
    private javax.swing.JLabel uvodzovkaL2;
    private javax.swing.JButton zaKohoButton;
    private javax.swing.JButton zivotopisButton;
    private javax.swing.JButton zobrazFvtButton;
    private javax.swing.JButton zobrazitButton;
    private javax.swing.JList zoznamList;
    // End of variables declaration//GEN-END:variables

  
}
