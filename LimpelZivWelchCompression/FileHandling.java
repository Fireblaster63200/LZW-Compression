package LimpelZivWelchCompression;

import java.io.*;

public class FileHandling
{
	private BufferedReader br;
	private FileOutputStream fos;
	private String source,destination;
	private boolean overwrite;

	FileHandling(String source)
	{
		this(source,source,false);
	}
	FileHandling(String source,String destination)
	{
		this(source,destination,false);
	}
	FileHandling(String source,String destination,boolean overwrite)
	{
		try
		{
			setSource(source);
			setDestination(destination);
		}catch(IOException ioe){}
		setOverwrite(overwrite);
	}
	
	public void setSource(String source)throws IOException,FileNotFoundException
	{
		this.source = source;
	}
	public void setDestination(String destination)throws IOException
	{
		this.destination = destination;
	}
	public void setOverwrite(boolean overwrite)
	{
		this.overwrite = overwrite;
	}
	public String getDestination()
	{
		return destination;
	}
	public String getSource()
	{
		return source;
	}
	public boolean isOverwrite()
	{
		return overwrite;
	}

	public String read()throws IOException,FileNotFoundException
	{
		br = new BufferedReader(new InputStreamReader(new FileInputStream(source)));
		String temp,readFile = "";
		while((temp = br.readLine()) != null)
			readFile += temp + "\n";
		return readFile;		
	}
	public void write(String textToWrite)throws IOException
	{
		fos = new FileOutputStream(destination,overwrite);
		fos.write(textToWrite.getBytes());
		fos.close();
	}
}
