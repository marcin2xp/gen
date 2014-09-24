package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controler.Generate;
import fr.opensagres.xdocreport.samples.docxandvelocity.model.AR;
import fr.opensagres.xdocreport.samples.docxandvelocity.model.MainTable;
import fr.opensagres.xdocreport.samples.docxandvelocity.model.WWB;
import fr.opensagres.xdocreport.samples.docxandvelocity.model.ZAO;
import javax.swing.ImageIcon;

public class MainWindowGui {

	public static JFrame frmGeneratorDokumentacji;
	private JTextField tfInitiativeName;
	private JTextField tfInitiativeNumber;
	private JTextField cbUnit;
	private JTextField tfbpa;
	private JTextField tfbpi;
	private JTextField tfBusiness;
	private JTextField tfAnalyst;
	private JTextField tfTechnical;
	private JTextField tfTerm;
	private JProgressBar progressBar;
	private JComboBox cbField;
	private JComboBox cbMode;
	private TextArea taDescription;
	private TextArea taBusiness;
	private JTextField tfFolderPath;
	private JTextField tfChangeHistoryWho;
	private JTextField tfChangeHistoryDate;
	private JCheckBox chckbxAR;
	private JTextField tfEffectiveness;
	private JTextField tfValidation;
	private JPanel panelAR;
	private TextArea taSolution;
	private JCheckBox chckbxAuto;
	private JCheckBox chckbxZAO;
	public static String WWBPath;
	public static String fileName = " ";
	private JTextField tfAnaDASodp;
	private JTextField tfAnaDATodp;
	private JTextField tfAnaDESodp;
	private JTextField tfAnaDITodp;
	private JTextField tfAnaDASpra;
	private JTextField tfAnaDATpra;
	private JTextField tfAnaDESpra;
	private JTextField tfAnaDITpra;
	private JTextField tfAnaKonFir;
	private JTextField tfAnaDosFir;
	private JTextField tfAnaPEIFir;
	private JTextField tfAnaKonPrac;
	private JTextField tfAnaDosPrac;
	private JTextField tfAnaPEIPrac;
	private JTextField tfAnaKonKoszt;
	private JTextField tfAnaDosKoszt;
	private JTextField tfAnaPEIKoszt;
	private JTextField tfAnaKontrUcze;
	private JTextField tfAnaDosUcze;
	private JTextField tfAnaPEIUcze;
	private JTextField tfReaDASodp;
	private JTextField tfReaDATodp;
	private JTextField tfReaDESodp;
	private JTextField tfReaDITodp;
	private JTextField tfReaDASpra;
	private JTextField tfReaDATpra;
	private JTextField tfReaDESpra;
	private JTextField tfReaDITpra;
	private JTextField tfReaKonFir;
	private JTextField tfReaDosFir;
	private JTextField tfReaPEIFir;
	private JTextField tfReaKonPrac;
	private JTextField tfReaDosPrac;
	private JTextField tfReaPEIPrac;
	private JTextField tfReaKonKoszt;
	private JTextField tfReaDosKoszt;
	private JTextField tfReaPEIKoszt;
	private JTextField tfReaKontrUcze;
	private JTextField tfReaDosUcze;
	private JTextField tfReaPEIUcze;
	private JPanel panelZAO;
	private JTextField tfsumaAnaPra;
	private JTextField tfAnaBIIodp;
	private JTextField tfAnaBIIpra;
	private JTextField tfsumaReaPra;
	private JTextField tfReaBIIodp;
	private JTextField tfReaBIIpra;
	private JCheckBox cbTarget1;
	private JCheckBox cbTarget2;
	private JCheckBox cbTarget3;
	private JCheckBox cbTarget4;
	private JCheckBox cbTarget5;
	private JCheckBox cbTarget6;
	private JCheckBox cbTarget7;
	private JCheckBox cbTarget8;
	private JCheckBox cbTarget9;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainWindowGui window = new MainWindowGui();
					window.frmGeneratorDokumentacji.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindowGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGeneratorDokumentacji = new JFrame();
		frmGeneratorDokumentacji.setResizable(false);
		frmGeneratorDokumentacji.setTitle("Generator dokumentacji ver. 0.1 beta");
		frmGeneratorDokumentacji.setBounds(100, 100, 820, 830);
		frmGeneratorDokumentacji.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGeneratorDokumentacji.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Rodzaj dokumentu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(6, 72, 310, 100);
		frmGeneratorDokumentacji.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox chckbxWWB = new JCheckBox("WWB - Wst\u0119pne wymagania biznesowe");
		chckbxWWB.setBounds(6, 20, 229, 23);
		panel_1.add(chckbxWWB);
		chckbxWWB.setEnabled(false);
		chckbxWWB.setSelected(true);
		
		chckbxAR = new JCheckBox("AR - Analiza rozwi\u0105zania");
		chckbxAR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxAR.isSelected()){
					System.out.println("Selected");
					//809 724
					frmGeneratorDokumentacji.setBounds(frmGeneratorDokumentacji.getX(),frmGeneratorDokumentacji.getY(),1300,830);
					panelAR.setVisible(true);
					
				} else {
					frmGeneratorDokumentacji.setBounds(frmGeneratorDokumentacji.getX(),frmGeneratorDokumentacji.getY(),820,830);
					panelAR.setVisible(false);

			}}
		});
		chckbxAR.setBounds(6, 46, 229, 23);
		panel_1.add(chckbxAR);
		
		chckbxZAO = new JCheckBox("ZAO - Za\u0142o\u017Cenia do analizy op\u0142acalno\u015Bci ");
		chckbxZAO.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxZAO.isSelected()){					
					//809 724
					frmGeneratorDokumentacji.setBounds(frmGeneratorDokumentacji.getX(),frmGeneratorDokumentacji.getY(),1300,830);
					panelZAO.setVisible(true);
					
				} else {
					frmGeneratorDokumentacji.setBounds(frmGeneratorDokumentacji.getX(),frmGeneratorDokumentacji.getY(),820,830);
					panelZAO.setVisible(false);
				}
			}
		});
		chckbxZAO.setBounds(6, 72, 229, 23);
		panel_1.add(chckbxZAO);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tabela g\u0142\u00F3wna", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(326, 72, 474, 266);
		frmGeneratorDokumentacji.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNazwaInicjatywy = new JLabel("Nazwa inicjatywy");
		lblNazwaInicjatywy.setBounds(27, 23, 83, 14);
		panel_2.add(lblNazwaInicjatywy);
		
		tfInitiativeName = new JTextField();
		tfInitiativeName.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				    warn();
				  }
				  public void removeUpdate(DocumentEvent e) {
				    warn();
				  }
				  public void insertUpdate(DocumentEvent e) {
				    warn();
				  }

				  public void warn() {
					  if (chckbxAuto.isSelected()){
						  tfEffectiveness.setText("ZAO- "+tfInitiativeName.getText());
					  }
				  }
				});
		tfInitiativeName.setBounds(124, 23, 339, 20);
		panel_2.add(tfInitiativeName);
		tfInitiativeName.setColumns(10);
		
		JLabel lblNumer = new JLabel("Numer");
		lblNumer.setBounds(79, 53, 31, 14);
		panel_2.add(lblNumer);
		
		tfInitiativeNumber = new JTextField();
		tfInitiativeNumber.setBounds(124, 49, 104, 20);
		panel_2.add(tfInitiativeNumber);
		tfInitiativeNumber.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(359, 48, 104, 22);
		panel_2.add(comboBox);
		comboBox.setEditable(true);
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"roboczy", "w fazie akceptcji", "odrzucony", "zaakceptowany", "zamkni\u0119ty"}));
		
		JLabel lblStatusDokumentu = new JLabel("Status dokumentu");
		lblStatusDokumentu.setBounds(252, 52, 97, 14);
		panel_2.add(lblStatusDokumentu);
		
		JLabel lblNewLabel = new JLabel("Obszar");
		lblNewLabel.setBounds(71, 84, 39, 14);
		panel_2.add(lblNewLabel);
		
		cbField = new JComboBox();
		cbField.setBounds(124, 79, 339, 22);
		panel_2.add(cbField);
		cbField.setModel(new DefaultComboBoxModel(new String[] {"Obszar Bankowo\u015Bci Korporacyjnej i Inwestycyjnej", "Obszar Informatyki i Us\u0142ug", "Obszar Rynku Detalicznego"}));
		
		JLabel lblJednostkaOrg = new JLabel("Jednostka Org.");
		lblJednostkaOrg.setBounds(36, 116, 74, 14);
		panel_2.add(lblJednostkaOrg);
		
		cbUnit = new JTextField();
		cbUnit.setBounds(124, 112, 339, 20);
		panel_2.add(cbUnit);
		cbUnit.setColumns(10);
		
		JLabel lblOba = new JLabel("BPA");
		lblOba.setBounds(86, 150, 19, 14);
		panel_2.add(lblOba);
		
		tfbpa = new JTextField();
		tfbpa.setBounds(124, 146, 104, 20);
		panel_2.add(tfbpa);
		tfbpa.setColumns(10);
		
		JLabel lblBpi = new JLabel("BPI");
		lblBpi.setBounds(318, 149, 31, 14);
		panel_2.add(lblBpi);
		
		tfbpi = new JTextField();
		tfbpi.setBounds(359, 146, 104, 20);
		panel_2.add(tfbpi);
		tfbpi.setColumns(10);
		
		JLabel lblKierownikBiznesowy = new JLabel("Kierownik Biznesowy");
		lblKierownikBiznesowy.setBounds(10, 178, 104, 14);
		panel_2.add(lblKierownikBiznesowy);
		
		tfBusiness = new JTextField();
		tfBusiness.setBounds(124, 174, 104, 20);
		panel_2.add(tfBusiness);
		tfBusiness.setColumns(10);
		
		JLabel lblAnalitykWiodcy = new JLabel("Analityk wiod\u0105cy");
		lblAnalitykWiodcy.setBounds(263, 180, 86, 14);
		panel_2.add(lblAnalitykWiodcy);
		
		tfAnalyst = new JTextField();
		tfAnalyst.setBounds(359, 177, 104, 20);
		panel_2.add(tfAnalyst);
		tfAnalyst.setColumns(10);
		
		JLabel lblKierownikTechniczny = new JLabel("Kierownik techniczny");
		lblKierownikTechniczny.setBounds(245, 208, 104, 14);
		panel_2.add(lblKierownikTechniczny);
		
		tfTechnical = new JTextField();
		tfTechnical.setBounds(359, 205, 104, 20);
		panel_2.add(tfTechnical);
		tfTechnical.setColumns(10);
		
		JLabel lblTerminRealizacji = new JLabel("Termin realizacji");
		lblTerminRealizacji.setBounds(27, 209, 83, 14);
		panel_2.add(lblTerminRealizacji);
		
		tfTerm = new JTextField();
		tfTerm.setBounds(124, 205, 104, 20);
		panel_2.add(tfTerm);
		tfTerm.setColumns(10);
		
		JLabel lblTrybRealizacji = new JLabel("Tryb realizacji");
		lblTrybRealizacji.setBounds(275, 237, 74, 14);
		panel_2.add(lblTrybRealizacji);
		
		cbMode = new JComboBox();
		cbMode.setBounds(359, 233, 104, 22);
		panel_2.add(cbMode);
		cbMode.setEnabled(false);
		cbMode.setEditable(true);
		cbMode.setModel(new DefaultComboBoxModel(new String[] {"uproszczony"}));
		
		progressBar = new JProgressBar();
		progressBar.setString("");
		progressBar.setStringPainted(true);
		progressBar.setBounds(671, 757, 129, 16);
		
		frmGeneratorDokumentacji.getContentPane().add(progressBar);
		
		JButton btnGenerate = new JButton("Generuj");
		
		btnGenerate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				generate();
			}

			private void generate() {
				progressBar.setIndeterminate(true);
				System.out.println("Generowanie...");
				setAllFields();
				progressBar.setIndeterminate(false);
				
			}
		});
		btnGenerate.setBounds(557, 750, 104, 23);
		frmGeneratorDokumentacji.getContentPane().add(btnGenerate);
		
		taDescription = new TextArea();
		taDescription.setBounds(9, 506, 791, 76);
		frmGeneratorDokumentacji.getContentPane().add(taDescription);
		
		JLabel lblOpisStanuObecnego = new JLabel("Opis stanu obecnego");
		lblOpisStanuObecnego.setBounds(9, 486, 129, 14);
		frmGeneratorDokumentacji.getContentPane().add(lblOpisStanuObecnego);
		
		taBusiness = new TextArea();
		taBusiness.setBounds(9, 618, 791, 121);
		frmGeneratorDokumentacji.getContentPane().add(taBusiness);
		
		JLabel lblWymaganiaBiznesowe = new JLabel("Wymagania biznesowe");
		lblWymaganiaBiznesowe.setBounds(9, 598, 129, 14);
		frmGeneratorDokumentacji.getContentPane().add(lblWymaganiaBiznesowe);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Folder docelowy dla wygenerowanych plik\u00F3w", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(4, 8, 793, 49);
		frmGeneratorDokumentacji.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnPrzegldaj = new JButton("Przegl\u0105daj...");
		btnPrzegldaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
		        JFileChooser f = new JFileChooser();
		        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
		        f.showSaveDialog(null);
		        System.out.println(f.getCurrentDirectory());
		        tfFolderPath.setText(String.valueOf((f.getSelectedFile())));
		        WWBPath = String.valueOf((f.getSelectedFile()));
		       		
			}
		});
		btnPrzegldaj.setBounds(6, 20, 91, 23);
		panel.add(btnPrzegldaj);
		
		tfFolderPath = new JTextField();
		tfFolderPath.setBounds(107, 21, 676, 20);
		panel.add(tfFolderPath);
		tfFolderPath.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Historia zmian", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 181, 306, 74);
		frmGeneratorDokumentacji.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblWprowadzi = new JLabel("Wprowadzi\u0142");
		lblWprowadzi.setBounds(39, 23, 64, 14);
		panel_3.add(lblWprowadzi);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(74, 48, 23, 14);
		panel_3.add(lblData);
		
		tfChangeHistoryWho = new JTextField();
		tfChangeHistoryWho.setBounds(107, 20, 189, 20);
		panel_3.add(tfChangeHistoryWho);
		tfChangeHistoryWho.setColumns(10);
		
		tfChangeHistoryDate = new JTextField();
		tfChangeHistoryDate.setBounds(107, 45, 189, 20);
		panel_3.add(tfChangeHistoryDate);
		tfChangeHistoryDate.setColumns(10);
		
		JButton btnChangeHistoryNow = new JButton("Dzi\u015B");
		btnChangeHistoryNow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tfChangeHistoryDate.setText(String.valueOf(new SimpleDateFormat("dd.MM.yyyy").format(Calendar.getInstance().getTime())));
			}
		});
		btnChangeHistoryNow.setBounds(10, 49, 54, 14);
		panel_3.add(btnChangeHistoryNow);
		
		panelAR = new JPanel();
		panelAR.setFocusable(false);
		panelAR.setVisible(false);
		panelAR.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "AR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAR.setBounds(810, 8, 480, 259);
		frmGeneratorDokumentacji.getContentPane().add(panelAR);
		panelAR.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Za\u0142\u0105cznik do wyceny op\u0142acalno\u015Bci");
		lblNewLabel_1.setBounds(12, 24, 166, 14);
		panelAR.add(lblNewLabel_1);
		
		tfEffectiveness = new JTextField();
		tfEffectiveness.setText("ZAO - ...");
		tfEffectiveness.setEditable(false);
		tfEffectiveness.setBounds(22, 49, 448, 20);
		panelAR.add(tfEffectiveness);
		tfEffectiveness.setColumns(10);
		
		chckbxAuto = new JCheckBox("auto");
		chckbxAuto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxAuto.isSelected()){
				tfEffectiveness.setEditable(false);
				}else {
					tfEffectiveness.setEditable(true);
				}
			}
		});
		chckbxAuto.setBounds(184, 20, 97, 23);
		panelAR.add(chckbxAuto);
		chckbxAuto.setSelected(true);
		
		JLabel lblWalidacjaArchitektoniczna = new JLabel("Walidacja architektoniczna");
		lblWalidacjaArchitektoniczna.setBounds(16, 83, 129, 14);
		panelAR.add(lblWalidacjaArchitektoniczna);
		
		tfValidation = new JTextField();
		tfValidation.setText("brak");
		tfValidation.setBounds(155, 80, 315, 20);
		panelAR.add(tfValidation);
		tfValidation.setColumns(10);
		
		JLabel lblSchematOglnejKoncepcji = new JLabel("Schemat og\u00F3lnej koncepcji rozwi\u0105zania");
		lblSchematOglnejKoncepcji.setBounds(14, 110, 192, 14);
		panelAR.add(lblSchematOglnejKoncepcji);
		
		taSolution = new TextArea();
		taSolution.setBounds(12, 130, 458, 120);
		panelAR.add(taSolution);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(6, 666, 87, -28);
		frmGeneratorDokumentacji.getContentPane().add(panel_4);
		
		panelZAO = new JPanel();
		panelZAO.setVisible(false);
		panelZAO.setToolTipText("");
		panelZAO.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "ZAO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelZAO.setBounds(810, 283, 486, 490);
		frmGeneratorDokumentacji.getContentPane().add(panelZAO);
		panelZAO.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(6, 20, 474, 459);
		panelZAO.add(tabbedPane);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Nak\u0142ady analizy", null, panel_5, null);
		panel_5.setLayout(null);		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 11, 449, 201);
		panel_5.add(panel_7);
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Udzia\u0142 Pionu Rozwoju i Utrzymania Aplikacji", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7.setLayout(null);
		

		
		JLabel lblNewLabel_4 = new JLabel("BII");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(10, 45, 46, 14);
		panel_7.add(lblNewLabel_4);
		
		JLabel lblDas = new JLabel("DAS");
		lblDas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDas.setBounds(10, 70, 46, 14);
		panel_7.add(lblDas);
		
		JLabel lblDat = new JLabel("DAT");
		lblDat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDat.setBounds(10, 95, 46, 14);
		panel_7.add(lblDat);
		
		JLabel lblDes = new JLabel("DES");
		lblDes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDes.setBounds(10, 120, 46, 14);
		panel_7.add(lblDes);
		
		JLabel lblDit = new JLabel("DIT");
		lblDit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDit.setBounds(10, 145, 46, 14);
		panel_7.add(lblDit);
		
		JLabel lblOdpowiedzialno = new JLabel("Odpowiedzialno\u015B\u0107");
		lblOdpowiedzialno.setBounds(88, 20, 85, 14);
		panel_7.add(lblOdpowiedzialno);
		
		JLabel lblPracochonno = new JLabel("Pracoch\u0142onno\u015B\u0107 [MD]");
		lblPracochonno.setBounds(280, 20, 108, 14);
		panel_7.add(lblPracochonno);
		
		tfAnaDASodp = new JTextField();
		tfAnaDASodp.setText("n/a");
		tfAnaDASodp.setBounds(66, 67, 156, 20);
		panel_7.add(tfAnaDASodp);
		tfAnaDASodp.setColumns(10);
		
		tfAnaDATodp = new JTextField();
		tfAnaDATodp.setText("n/a");
		tfAnaDATodp.setBounds(66, 92, 156, 20);
		panel_7.add(tfAnaDATodp);
		tfAnaDATodp.setColumns(10);
		
		tfAnaDESodp = new JTextField();
		tfAnaDESodp.setText("n/a");
		tfAnaDESodp.setBounds(66, 117, 156, 20);
		panel_7.add(tfAnaDESodp);
		tfAnaDESodp.setColumns(10);
		
		tfAnaDITodp = new JTextField();
		tfAnaDITodp.setText("n/a");
		tfAnaDITodp.setBounds(66, 142, 156, 20);
		panel_7.add(tfAnaDITodp);
		tfAnaDITodp.setColumns(10);
		
		tfAnaDASpra = new JTextField();
		tfAnaDASpra.setBounds(294, 64, 85, 20);
		panel_7.add(tfAnaDASpra);
		tfAnaDASpra.setColumns(10);
		
		tfAnaDATpra = new JTextField();
		tfAnaDATpra.setBounds(294, 89, 85, 20);
		panel_7.add(tfAnaDATpra);
		tfAnaDATpra.setColumns(10);
		
		tfAnaDESpra = new JTextField();
		tfAnaDESpra.setBounds(294, 114, 85, 20);
		panel_7.add(tfAnaDESpra);
		tfAnaDESpra.setColumns(10);
		
		tfAnaDITpra = new JTextField();
		tfAnaDITpra.setBounds(294, 139, 85, 20);
		panel_7.add(tfAnaDITpra);
		tfAnaDITpra.setColumns(10);
		
		JLabel lblRazem = new JLabel("Razem:");
		lblRazem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRazem.setBounds(237, 173, 46, 14);
		panel_7.add(lblRazem);
		
		tfsumaAnaPra = new JTextField();
		tfsumaAnaPra.setBounds(293, 170, 86, 20);
		panel_7.add(tfsumaAnaPra);
		tfsumaAnaPra.setColumns(10);
		
		tfAnaBIIodp = new JTextField();
		tfAnaBIIodp.setText("n/a");
		tfAnaBIIodp.setBounds(66, 42, 156, 20);
		panel_7.add(tfAnaBIIodp);
		tfAnaBIIodp.setColumns(10);
		
		tfAnaBIIpra = new JTextField();
		tfAnaBIIpra.setColumns(10);
		tfAnaBIIpra.setBounds(294, 39, 85, 20);
		panel_7.add(tfAnaBIIpra);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 211, 449, 122);
		panel_5.add(panel_8);
		panel_8.setToolTipText("");
		panel_8.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Udzia\u0142 pozosta\u0142ych uczestnik\u00F3w", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Uczestnicy");
		lblNewLabel_3.setBounds(157, 20, 57, 14);
		panel_8.add(lblNewLabel_3);
		
		JLabel lblKontraktorzyZewntrzni = new JLabel("Kontraktorzy zewn\u0119trzni");
		lblKontraktorzyZewntrzni.setBounds(6, 45, 126, 14);
		panel_8.add(lblKontraktorzyZewntrzni);
		lblKontraktorzyZewntrzni.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblDostawcyZewntrzni = new JLabel("Dostawcy zewn\u0119trzni");
		lblDostawcyZewntrzni.setBounds(6, 70, 126, 14);
		panel_8.add(lblDostawcyZewntrzni);
		lblDostawcyZewntrzni.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblPei = new JLabel("PEI");
		lblPei.setBounds(6, 95, 126, 14);
		panel_8.add(lblPei);
		lblPei.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfAnaKonFir = new JTextField();
		tfAnaKonFir.setBounds(264, 39, 47, 20);
		panel_8.add(tfAnaKonFir);
		tfAnaKonFir.setColumns(10);
		
		tfAnaDosFir = new JTextField();
		tfAnaDosFir.setBounds(264, 64, 47, 20);
		panel_8.add(tfAnaDosFir);
		tfAnaDosFir.setColumns(10);
		
		tfAnaPEIFir = new JTextField();
		tfAnaPEIFir.setBounds(264, 89, 47, 20);
		panel_8.add(tfAnaPEIFir);
		tfAnaPEIFir.setColumns(10);
		
		tfAnaKonPrac = new JTextField();
		tfAnaKonPrac.setBounds(335, 39, 47, 20);
		panel_8.add(tfAnaKonPrac);
		tfAnaKonPrac.setColumns(10);
		
		tfAnaDosPrac = new JTextField();
		tfAnaDosPrac.setBounds(335, 64, 47, 20);
		panel_8.add(tfAnaDosPrac);
		tfAnaDosPrac.setColumns(10);
		
		tfAnaPEIPrac = new JTextField();
		tfAnaPEIPrac.setBounds(335, 89, 47, 20);
		panel_8.add(tfAnaPEIPrac);
		tfAnaPEIPrac.setColumns(10);
		
		tfAnaKonKoszt = new JTextField();
		tfAnaKonKoszt.setBounds(392, 39, 47, 20);
		panel_8.add(tfAnaKonKoszt);
		tfAnaKonKoszt.setColumns(10);
		
		tfAnaDosKoszt = new JTextField();
		tfAnaDosKoszt.setBounds(392, 64, 47, 20);
		panel_8.add(tfAnaDosKoszt);
		tfAnaDosKoszt.setColumns(10);
		
		tfAnaPEIKoszt = new JTextField();
		tfAnaPEIKoszt.setBounds(392, 89, 47, 20);
		panel_8.add(tfAnaPEIKoszt);
		tfAnaPEIKoszt.setColumns(10);
		
		JLabel lblFirmyJednostki = new JLabel("Firmy / Jednostki");
		lblFirmyJednostki.setBounds(235, 20, 90, 14);
		panel_8.add(lblFirmyJednostki);
		
		JLabel lblPracochonno_1 = new JLabel("Pracoch\u0142onno\u015B\u0107");
		lblPracochonno_1.setBounds(321, 20, 90, 14);
		panel_8.add(lblPracochonno_1);
		
		JLabel lblKoszt = new JLabel("Koszt");
		lblKoszt.setBounds(403, 20, 33, 14);
		panel_8.add(lblKoszt);
		
		tfAnaKontrUcze = new JTextField();
		tfAnaKontrUcze.setText("n/a");
		tfAnaKontrUcze.setColumns(10);
		tfAnaKontrUcze.setBounds(141, 39, 85, 20);
		panel_8.add(tfAnaKontrUcze);
		
		tfAnaDosUcze = new JTextField();
		tfAnaDosUcze.setText("n/a");
		tfAnaDosUcze.setColumns(10);
		tfAnaDosUcze.setBounds(141, 64, 85, 20);
		panel_8.add(tfAnaDosUcze);
		
		tfAnaPEIUcze = new JTextField();
		tfAnaPEIUcze.setText("n/a");
		tfAnaPEIUcze.setColumns(10);
		tfAnaPEIUcze.setBounds(141, 89, 85, 20);
		panel_8.add(tfAnaPEIUcze);
		
		JPanel panel_10 = new JPanel();
		tabbedPane.addTab("Nak\u0142ady realizacji", null, panel_10, null);
		panel_10.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 11, 449, 201);
		panel_10.add(panel_6);
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Udzia\u0142 Pionu Rozwoju i Utrzymania Aplikacji", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel label = new JLabel("BII");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setHorizontalTextPosition(SwingConstants.LEADING);
		label.setBounds(10, 45, 46, 14);
		panel_6.add(label);
		
		JLabel label_1 = new JLabel("DAS");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(10, 70, 46, 14);
		panel_6.add(label_1);
		
		JLabel label_2 = new JLabel("DAT");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(10, 95, 46, 14);
		panel_6.add(label_2);
		
		JLabel label_3 = new JLabel("DES");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(10, 120, 46, 14);
		panel_6.add(label_3);
		
		JLabel label_4 = new JLabel("DIT");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(10, 145, 46, 14);
		panel_6.add(label_4);
		
		JLabel label_5 = new JLabel("Odpowiedzialno\u015B\u0107");
		label_5.setBounds(88, 20, 85, 14);
		panel_6.add(label_5);
		
		JLabel label_6 = new JLabel("Pracoch\u0142onno\u015B\u0107 [MD]");
		label_6.setBounds(280, 20, 108, 14);
		panel_6.add(label_6);
		
		tfReaDASodp = new JTextField();
		tfReaDASodp.setText("n/a");
		tfReaDASodp.setColumns(10);
		tfReaDASodp.setBounds(66, 67, 156, 20);
		panel_6.add(tfReaDASodp);
		
		tfReaDATodp = new JTextField();
		tfReaDATodp.setText("n/a");
		tfReaDATodp.setColumns(10);
		tfReaDATodp.setBounds(66, 92, 156, 20);
		panel_6.add(tfReaDATodp);
		
		tfReaDESodp = new JTextField();
		tfReaDESodp.setText("n/a");
		tfReaDESodp.setColumns(10);
		tfReaDESodp.setBounds(66, 117, 156, 20);
		panel_6.add(tfReaDESodp);
		
		tfReaDITodp = new JTextField();
		tfReaDITodp.setText("n/a");
		tfReaDITodp.setColumns(10);
		tfReaDITodp.setBounds(66, 142, 156, 20);
		panel_6.add(tfReaDITodp);
		
		tfReaDASpra = new JTextField();
		tfReaDASpra.setColumns(10);
		tfReaDASpra.setBounds(294, 64, 85, 20);
		panel_6.add(tfReaDASpra);
		
		tfReaDATpra = new JTextField();
		tfReaDATpra.setColumns(10);
		tfReaDATpra.setBounds(294, 89, 85, 20);
		panel_6.add(tfReaDATpra);
		
		tfReaDESpra = new JTextField();
		tfReaDESpra.setColumns(10);
		tfReaDESpra.setBounds(294, 114, 85, 20);
		panel_6.add(tfReaDESpra);
		
		tfReaDITpra = new JTextField();
		tfReaDITpra.setColumns(10);
		tfReaDITpra.setBounds(294, 139, 85, 20);
		panel_6.add(tfReaDITpra);
		
		tfsumaReaPra = new JTextField();
		tfsumaReaPra.setColumns(10);
		tfsumaReaPra.setBounds(294, 170, 85, 20);
		panel_6.add(tfsumaReaPra);
		
		JLabel lblRazem_1 = new JLabel("Razem:");
		lblRazem_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRazem_1.setBounds(238, 173, 46, 14);
		panel_6.add(lblRazem_1);
		
		tfReaBIIodp = new JTextField();
		tfReaBIIodp.setText("n/a");
		tfReaBIIodp.setColumns(10);
		tfReaBIIodp.setBounds(66, 42, 156, 20);
		panel_6.add(tfReaBIIodp);
		
		tfReaBIIpra = new JTextField();
		tfReaBIIpra.setColumns(10);
		tfReaBIIpra.setBounds(294, 39, 85, 20);
		panel_6.add(tfReaBIIpra);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(10, 211, 449, 122);
		panel_10.add(panel_9);
		panel_9.setLayout(null);
		panel_9.setToolTipText("");
		panel_9.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Udzia\u0142 pozosta\u0142ych uczestnik\u00F3w", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel label_7 = new JLabel("Uczestnicy");
		label_7.setBounds(157, 20, 57, 14);
		panel_9.add(label_7);
		
		JLabel label_8 = new JLabel("Kontraktorzy zewn\u0119trzni");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(6, 45, 126, 14);
		panel_9.add(label_8);
		
		JLabel label_9 = new JLabel("Dostawcy zewn\u0119trzni");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setBounds(6, 70, 126, 14);
		panel_9.add(label_9);
		
		JLabel label_10 = new JLabel("PEI");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(6, 95, 126, 14);
		panel_9.add(label_10);
		
		tfReaKonFir = new JTextField();
		tfReaKonFir.setColumns(10);
		tfReaKonFir.setBounds(264, 39, 47, 20);
		panel_9.add(tfReaKonFir);
		
		tfReaDosFir = new JTextField();
		tfReaDosFir.setColumns(10);
		tfReaDosFir.setBounds(264, 64, 47, 20);
		panel_9.add(tfReaDosFir);
		
		tfReaPEIFir = new JTextField();
		tfReaPEIFir.setColumns(10);
		tfReaPEIFir.setBounds(264, 89, 47, 20);
		panel_9.add(tfReaPEIFir);
		
		tfReaKonPrac = new JTextField();
		tfReaKonPrac.setColumns(10);
		tfReaKonPrac.setBounds(335, 39, 47, 20);
		panel_9.add(tfReaKonPrac);
		
		tfReaDosPrac = new JTextField();
		tfReaDosPrac.setColumns(10);
		tfReaDosPrac.setBounds(335, 64, 47, 20);
		panel_9.add(tfReaDosPrac);
		
		tfReaPEIPrac = new JTextField();
		tfReaPEIPrac.setColumns(10);
		tfReaPEIPrac.setBounds(335, 89, 47, 20);
		panel_9.add(tfReaPEIPrac);
		
		tfReaKonKoszt = new JTextField();
		tfReaKonKoszt.setColumns(10);
		tfReaKonKoszt.setBounds(392, 39, 47, 20);
		panel_9.add(tfReaKonKoszt);
		
		tfReaDosKoszt = new JTextField();
		tfReaDosKoszt.setColumns(10);
		tfReaDosKoszt.setBounds(392, 64, 47, 20);
		panel_9.add(tfReaDosKoszt);
		
		tfReaPEIKoszt = new JTextField();
		tfReaPEIKoszt.setColumns(10);
		tfReaPEIKoszt.setBounds(392, 89, 47, 20);
		panel_9.add(tfReaPEIKoszt);
		
		JLabel label_11 = new JLabel("Firmy / Jednostki");
		label_11.setBounds(235, 20, 90, 14);
		panel_9.add(label_11);
		
		JLabel label_12 = new JLabel("Pracoch\u0142onno\u015B\u0107");
		label_12.setBounds(321, 20, 90, 14);
		panel_9.add(label_12);
		
		JLabel label_13 = new JLabel("Koszt");
		label_13.setBounds(403, 20, 33, 14);
		panel_9.add(label_13);
		
		tfReaKontrUcze = new JTextField();
		tfReaKontrUcze.setText("n/a");
		tfReaKontrUcze.setColumns(10);
		tfReaKontrUcze.setBounds(141, 39, 85, 20);
		panel_9.add(tfReaKontrUcze);
		
		tfReaDosUcze = new JTextField();
		tfReaDosUcze.setText("n/a");
		tfReaDosUcze.setColumns(10);
		tfReaDosUcze.setBounds(141, 64, 85, 20);
		panel_9.add(tfReaDosUcze);
		
		tfReaPEIUcze = new JTextField();
		tfReaPEIUcze.setText("n/a");
		tfReaPEIUcze.setColumns(10);
		tfReaPEIUcze.setBounds(141, 89, 85, 20);
		panel_9.add(tfReaPEIUcze);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Cel inicjatywy", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_11.setBounds(9, 256, 307, 219);
		frmGeneratorDokumentacji.getContentPane().add(panel_11);
		panel_11.setLayout(null);
		
		cbTarget1 = new JCheckBox("wymogi regulacyjne zewn\u0119trzne ");
		cbTarget1.setBounds(6, 20, 201, 23);
		panel_11.add(cbTarget1);
		
		cbTarget2 = new JCheckBox("wymogi przepis\u00F3w wewn\u0119trznych ");
		cbTarget2.setBounds(6, 38, 189, 23);
		panel_11.add(cbTarget2);
		
		cbTarget3 = new JCheckBox("audyt ");
		cbTarget3.setBounds(6, 57, 180, 23);
		panel_11.add(cbTarget3);
		
		cbTarget6 = new JCheckBox("minimalizacja ryzyka operacyjnego/ bezpiecze\u0144stwo");
		cbTarget6.setBounds(6, 112, 295, 23);
		panel_11.add(cbTarget6);
		
		cbTarget5 = new JCheckBox("obni\u017Cka koszt\u00F3w");
		cbTarget5.setBounds(6, 93, 201, 23);
		panel_11.add(cbTarget5);
		
		cbTarget4 = new JCheckBox("wzrost przychod\u00F3w (nowy Biznes)");
		cbTarget4.setBounds(6, 75, 201, 23);
		panel_11.add(cbTarget4);
		
		cbTarget9 = new JCheckBox("inne \u2013 ");
		cbTarget9.setBounds(6, 169, 180, 23);
		panel_11.add(cbTarget9);
		
		cbTarget8 = new JCheckBox("wym\u00F3g technologiczny / poprawa b\u0142\u0119d\u00F3w / wydajno\u015B\u0107");
		cbTarget8.setBounds(6, 150, 295, 23);
		panel_11.add(cbTarget8);
		
		cbTarget7 = new JCheckBox("efektywno\u015B\u0107 / optymalizacja proces\u00F3w");
		cbTarget7.setBounds(6, 132, 259, 23);
		panel_11.add(cbTarget7);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainWindowGui.class.getResource("/fr/opensagres/xdocreport/samples/docxandvelocity/logo_pkobp.png")));
		lblNewLabel_2.setBounds(326, 373, 137, 102);
		frmGeneratorDokumentacji.getContentPane().add(lblNewLabel_2);
		
		JMenuBar menuBar = new JMenuBar();
		frmGeneratorDokumentacji.setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("Wi\u0119cej");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pomoc");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
	}

	protected void setAllFields() {
		MainTable mainTable = new MainTable();
		WWB wwb = new WWB();
		mainTable.setInitiativeName(tfInitiativeName.getText());
		mainTable.setInitiativeNumber(tfInitiativeNumber.getText());
		mainTable.setUnit(cbUnit.getText());
		mainTable.setField(String.valueOf(cbField.getSelectedItem()));
		mainTable.setBusiness(tfBusiness.getText());
		mainTable.setBpa(tfbpa.getText());
		mainTable.setBpi(tfbpi.getText());
		mainTable.setAnalyst(tfAnalyst.getText());
		mainTable.setTerm(tfTerm.getText());
		mainTable.setTechnical(tfTechnical.getText());
		mainTable.setWhocreate(tfChangeHistoryWho.getText());
		mainTable.setDate(tfChangeHistoryDate.getText());
		mainTable.setMode(String.valueOf(cbMode.getSelectedItem()));
		
		wwb.setDescription(String.valueOf(taDescription.getText()));
		wwb.setBusiness(String.valueOf(taBusiness.getText()));
		
		if(cbTarget1.isSelected()){
			wwb.setTarget1("[X]");
		}
		if(cbTarget2.isSelected()){
			wwb.setTarget2("[X]");
		}
		if(cbTarget3.isSelected()){
			wwb.setTarget3("[X]");
		}
		if(cbTarget4.isSelected()){
			wwb.setTarget4("[X]");
		}
		if(cbTarget5.isSelected()){
			wwb.setTarget5("[X]");
		}
		if(cbTarget6.isSelected()){
			wwb.setTarget6("[X]");
		}
		if(cbTarget7.isSelected()){
			wwb.setTarget7("[X]");
		}
		if(cbTarget8.isSelected()){
			wwb.setTarget8("[X]");
		}
		if(cbTarget9.isSelected()){
			wwb.setTarget9("[X]");
		}
		
		fileName =  tfInitiativeName.getText();		
		if (chckbxAR.isSelected()){
			AR ar = new AR();
			ar.setBusiness(taBusiness.getText());
			ar.setEffectiveness(tfEffectiveness.getText());
			ar.setSolution(taSolution.getText());
			ar.setValidation(tfValidation.getText());
			
			Generate generate = new Generate();
			generate.runAR(mainTable, ar);
		}
		
		if (chckbxZAO.isSelected()){
			ZAO zao = new ZAO();
			zao.setAnaBIIodp(tfAnaBIIodp.getText());
			zao.setAnaBIIpra(tfAnaBIIpra.getText());
			zao.setAnaDASodp(tfAnaDASodp.getText());
			zao.setAnaDASpra(tfAnaDASpra.getText());
			zao.setAnaDATodp(tfAnaDATodp.getText());
			zao.setAnaDATpra(tfAnaDATpra.getText());
			zao.setAnaDDITpra(tfAnaDITpra.getText());
			zao.setAnaDESodp(tfAnaDESodp.getText());
			zao.setAnaDESpra(tfAnaDESpra.getText());
			zao.setAnaDITodp(tfAnaDITodp.getText());
			zao.setAnaDosFir(tfAnaDosFir.getText());
			zao.setAnaDosKoszt(tfAnaDosKoszt.getText());
			zao.setAnaDosPrac(tfAnaDosPrac.getText());
			zao.setAnaDosUcze(tfAnaDosUcze.getText());
			zao.setAnaKonFir(tfAnaKonFir.getText());
			zao.setAnaKonKoszt(tfAnaKonKoszt.getText());
			zao.setAnaKonPrac(tfAnaKonPrac.getText());
			zao.setAnaKontrUcze(tfAnaKontrUcze.getText());
			zao.setAnaPEIFir(tfAnaPEIFir.getText());
			zao.setAnaPEIKoszt(tfAnaPEIKoszt.getText());
			zao.setAnaPEIPrac(tfAnaPEIPrac.getText());
			zao.setAnaPEIUcze(tfAnaPEIUcze.getText());
			zao.setSumaAnaPra(tfsumaAnaPra.getText());
			zao.setReaBIIodp(tfReaBIIodp.getText());
			zao.setReaBIIpra(tfReaBIIpra.getText());
			zao.setReaaDosFir(tfReaDosFir.getText());
			zao.setReaDASodp(tfReaDASodp.getText());
			zao.setReaDASpra(tfReaDASpra.getText());
			zao.setReaDATodp(tfReaDATodp.getText());
			zao.setReaDATpra(tfReaDATpra.getText());
			zao.setReaDATodp(tfReaDATodp.getText());
			zao.setReaDDITpra(tfReaDITpra.getText());
			zao.setReaDESodp(tfReaDESodp.getText());
			zao.setReaDESpra(tfReaDESpra.getText());
			zao.setReaDITodp(tfReaDITodp.getText());
			zao.setReaDosKoszt(tfReaDosKoszt.getText());
			zao.setReaDosPrac(tfReaDosPrac.getText());
			zao.setReaDosUcze(tfReaDosUcze.getText());
			zao.setReaKonFir(tfReaKonFir.getText());
			zao.setReaKonKoszt(tfReaKonKoszt.getText());
			zao.setReaKonPrac(tfReaKonPrac.getText());
			zao.setReaKontrUcze(tfReaKontrUcze.getText());
			zao.setReaPEIFir(tfReaPEIFir.getText());
			zao.setReaPEIKoszt(tfReaPEIKoszt.getText());
			zao.setReaPEIPrac(tfReaPEIPrac.getText());
			zao.setReaPEIUcze(tfReaPEIUcze.getText());
			zao.setSumaReaPra(tfsumaReaPra.getText());
			
			Generate generate = new Generate();			
			generate.runZAO(mainTable, zao);
		}
		
		Generate generate = new Generate();
		if(generate.runWWB(mainTable, wwb)){			
			JOptionPane.showMessageDialog(frmGeneratorDokumentacji,
				    "Generowanie zakonczone powodzeniem");
		} else {
			JOptionPane.showMessageDialog(frmGeneratorDokumentacji,
				    "Podczas generowania wystapil blad",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
}
//TO DO
//Sprawdzanie przy generowaniu czy scie¿ka nie jest nulem czy nie jest pusta oraz czy jest poprawna
//Przeprowadzic szczegolowy test
//W nazwie inicjatywy obs³uzyc niedozwolone znaki dla nazwy pliku
