import java.io.*;
public class FileOperations
{
    FileReader fin=null;
    FileWriter fout=null;
    File fileObj;
    public FileOperations(String dir,String file)
    {
        fileObj = new File(dir,file);
    }

    public FileOperations(File fileObj)
    {
        this.fileObj = fileObj;
    }

    public String readFile()
    {
        char[] str=new char[(int)fileObj.length()];
        try
        {
            int c,i=0;
            fin = new FileReader(fileObj);
            while((c = fin.read())!=-1)
            {
                str[i]=(char )c;
                i++;
            }
        }
        catch(IOException e)
        { }
        finally
        {
            try {
                if (fin != null) {
                    fin.close();
                }
            }catch (IOException e)
            {}
        }
        String read = new String(str);
        return(read);
    }

    public void writeFile(String write)
    {
        char buffer[] = new char[write.length()];
        write.getChars(0,write.length(),buffer,0);
        try
        {
            fout = new FileWriter(fileObj);
            fout.write(buffer);
        }
        catch(IOException e)
        { }
        finally
        {
            try {
                if (fout != null) {
                    fout.close();
                }
            }catch (IOException e)
            {}
        }
    }
}
