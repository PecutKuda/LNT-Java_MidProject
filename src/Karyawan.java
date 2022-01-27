import java.util.Comparator;

public class Karyawan implements Comparable<Karyawan>
{
	String ID;
	String nama;
	String gender;
	String jabatan;
	int gaji;
	
	public String getID()
	{
		return ID;
	}
	public void setID(String ID)
	{
		this.ID = ID;
	}
	public String getnama()
	{
		return nama;
	}
	public void setnama(String nama)
	{
		this.nama = nama;
	}
	public String getgender()
	{
		return gender;
	}
	public void setgender(String gender)
	{
		this.gender = gender;
	}
	public String getjabatan()
	{
		return jabatan;
	}
	public void setjabatan(String jabatan)
	{
		this.jabatan = jabatan;
	}
	public int getgaji()
	{
		return gaji;
	}
	public void setgaji(int gaji)
	{
		this.gaji = gaji;
	}
	@Override
	public int compareTo(Karyawan karyawans)
	{
		return this.nama.compareTo(karyawans.nama);
	}
	public Karyawan(String ID, String nama, String gender, String jabatan, int gaji) 
	{
		// TODO Auto-generated constructor stub
		super();
		this.ID = ID;
		this.nama = nama;
		this.gender = gender;
		this.jabatan = jabatan;
		this.gaji = gaji;
	}
}
//class NameComparator implements Comparator<Karyawan>
//{
//	public int compare(Karyawan kar1, Karyawan kar2)
//	{
//		return kar1.getnama().compareTo(kar2.getnama());
//	}	
//}
