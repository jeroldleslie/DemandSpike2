package com.neverwinterdp.demandspike;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;



public class DemandSpike {

	
	private class demandspikeCommands{
	    //////////////////////////////////////////////////////////////////////////////////////
	    //Command line args
	    @Parameter(names={"run"},description="Run test job")
	    public boolean run = false;
	   
	    @Parameter(names={"-help","--help","-h"}, description="Displays help message")
	    public boolean help = false;
	    //////////////////////////////////////////////////////////////////////////////////////
	  }
	
	
	private static Logger logger;
	private boolean help;
	public static void main(String[] args) {
		try {
			DemandSpike ds = new DemandSpike(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DemandSpike(String args[]) {
		logger = LoggerFactory.getLogger("DemandSpike");
		logger.info("Initializing DemandSpike object");
		for (int i = 0; i < args.length; i++) {
			logger.info("Args passed in:" + args[i]);
		}
		
		// Exit out if there's a problem parsing out command line args
		// Or if the help flag was passed in
		if (!this.parseCommandLine(args) || this.help) {
			System.exit(-1);
		}
	}
	
	
	 public boolean parseCommandLine(String[] args){
		 	demandspikeCommands parser = new demandspikeCommands();
		    JCommander jcomm=null;
		    try{
		      jcomm = new JCommander(parser, args);
		    }
		    catch(ParameterException e){
		      System.err.println(e.getMessage()+"\nUse the -h option to get usage");
		      return false;
		    }
		  
		    if (args.length < 2) {
		    	jcomm.usage();
		        return true;
		    }
		    
		    this.help = parser.help;
		    
		    //If -help was on command line,
		    //Print out help message
		    if (this.help){
		      jcomm.usage();
		    }
		    return true;
		  }
}
