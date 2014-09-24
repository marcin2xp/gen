package controler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JOptionPane;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.samples.docxandvelocity.DocxProjectWithVelocity;
import fr.opensagres.xdocreport.samples.docxandvelocity.model.AR;
import fr.opensagres.xdocreport.samples.docxandvelocity.model.MainTable;
import fr.opensagres.xdocreport.samples.docxandvelocity.model.WWB;
import fr.opensagres.xdocreport.samples.docxandvelocity.model.ZAO;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import gui.MainWindowGui;

public class Generate {
	
	public void filePathError(){
		if (MainWindowGui.WWBPath == null){
			JOptionPane.showMessageDialog(MainWindowGui.frmGeneratorDokumentacji,
				    "Wybierz folder docelowy dla wygenerowanych plikow",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);		
		}
				
	}
	
	public boolean runWWB(MainTable mainTable, WWB wwb){

    
        try
        {
            // 1) Load Docx file by filling Velocity template engine and cache
            // it to the registry
            InputStream in = DocxProjectWithVelocity.class.getResourceAsStream( "WWBtemplate.docx" );
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

            // 2) Create context Java model
            IContext context = report.createContext();           
             
            context.put("maintable", mainTable);
            context.put("wwb", wwb);

            // 3) Generate report by merging Java model with the Docx           
            
            String path = MainWindowGui.WWBPath;
            OutputStream out = new FileOutputStream( new File( path + "\\WWB- " + MainWindowGui.fileName +".docx" ) );
            report.process( context, out );            
   
            System.out.println("Success");
            return true;
        }
        catch ( IOException e )
        {
            e.printStackTrace();
            filePathError();            
        }
        catch ( XDocReportException e )
        {
            e.printStackTrace();
        }
		return false;
    }
	public boolean runAR(MainTable mainTable, AR ar){
	
        try
        {
            // 1) Load Docx file by filling Velocity template engine and cache
            // it to the registry
            InputStream in = DocxProjectWithVelocity.class.getResourceAsStream( "ARtemplate.docx" );
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

            // 2) Create context Java model
            IContext context = report.createContext();           
             
            context.put("maintable", mainTable);
            context.put("ar", ar);

            // 3) Generate report by merging Java model with the Docx           
            
            String path = MainWindowGui.WWBPath;
            OutputStream out = new FileOutputStream( new File( path + "\\AR- " + MainWindowGui.fileName +".docx" ) );
            report.process( context, out );
   
            System.out.println("Success");
            return true;
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        catch ( XDocReportException e )
        {
            e.printStackTrace();
        }
		return false;
    }
	
	public boolean runZAO(MainTable mainTable, ZAO zao){		
        try
        {
            // 1) Load Docx file by filling Velocity template engine and cache
            // it to the registry
            InputStream in = DocxProjectWithVelocity.class.getResourceAsStream( "ZAOtemplate.docx" );
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport( in, TemplateEngineKind.Velocity );

            // 2) Create context Java model
            IContext context = report.createContext();           
             
            context.put("maintable", mainTable);
            context.put("zao", zao);

            // 3) Generate report by merging Java model with the Docx           
            
            String path = MainWindowGui.WWBPath;
            OutputStream out = new FileOutputStream( new File( path + "\\ZAO- " + MainWindowGui.fileName +".docx" ) );
            report.process( context, out );
   
            System.out.println("Success");
            return true;
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        catch ( XDocReportException e )
        {
            e.printStackTrace();
        }
		return false;
    }
	
}


