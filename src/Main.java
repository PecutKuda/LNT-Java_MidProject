import java.util.Scanner;
import java.util.Vector;
import java.util.Collection;
import java.util.Collections;

public class Main 
{
	Vector<Karyawan> karyawans = new Vector<Karyawan>();
	Scanner sc = new Scanner(System.in);
	void Menu() //ok
	{
		System.out.println("Selamat datang di Aplikasi Karyawan PT Musang!\n");
		System.out.println("1. Insert data karyawan");
		System.out.println("2. View data karyawan");
		System.out.println("3. Update data karyawan");
		System.out.println("4. Delete data karyawan");
		System.out.println("=====================================================");
		System.out.print("Masukkan input >> ");
	}
	void ViewData() //ok
	{
		
		if (karyawans.size() > 0)
		{
			System.out.println("|----|-----------------|------------------------------|-----------------|-----------------|-----------------|");
			System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin    |Jabatan          |Gaji Karyawan    |");
			System.out.println("|----|-----------------|------------------------------|-----------------|-----------------|-----------------|");
			//System.out.printf("%d\n", karyawans.size());
			for (int i=0; i<karyawans.size(); i++)
			{
				System.out.printf("|%4d|%17s|%30s|%17s|%17s|%17d|\n", i+1, karyawans.get(i).getID(), karyawans.get(i).getnama(), karyawans.get(i).getgender(), karyawans.get(i).getjabatan(), karyawans.get(i).getgaji());
			}
			System.out.println("|----|-----------------|------------------------------|-----------------|-----------------|-----------------|");
		}
		else System.out.println("No data available to show..."); 
	}	
	void InsertData() //ok
	{
		String name, gender, role, ID;
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String nums = "0123456789";
		
		while(true)
		{
			System.out.println("Input nama karyawan [>= 3]: ");
			name = sc.nextLine();
			if(name.length() >= 3) break;
		}
		while(true)
		{
			System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			gender = sc.nextLine();
			if (gender.compareTo("Laki-laki") == 0 || gender.compareTo("Perempuan") == 0) break;
		}
		while(true)
		{
			System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			role = sc.nextLine();
			if (role.compareTo("Manager") == 0 || role.compareTo("Supervisor") == 0 || role.compareTo("Admin") == 0) break;
		}
		//Generate random ID
		while (true)
		{
			int flag=0;
			ID = "";
			for (var i = 0; i<2; i++)
			{
				ID += chars.charAt((int) Math.floor(Math.random() * 26));
			}
			ID += "-";
			for (var i = 0; i<4; i++)
			{
				ID += nums.charAt((int) Math.floor(Math.random() * 10));
			}
			for (int i=0; i<karyawans.size(); i++)
			{
				if (ID == karyawans.get(i).getID()) 
				{	
					flag=1;
					break;
				}
			}
			if (flag==0) break;
		}
		System.out.println("Berhasil menambahkan karyawan dengan id " + ID);
		int bonus = 0;
		int total = 0;
		int mctr=0, sctr=0, actr=0;
		for (int i=0; i<karyawans.size(); i++)
		{
			if (karyawans.get(i).getjabatan().compareTo("Manager") == 0) mctr++;
			else if (karyawans.get(i).getjabatan().compareTo("Supervisor") == 0) sctr++;
			else actr++;
		}
		int exist=0;
		if (mctr >= 3)
		{
			for (int i=0; i<karyawans.size(); i++)
			{
				if (karyawans.get(i).getjabatan().compareTo("Manager") == 0) 
				{
					total = karyawans.get(i).getgaji();
					bonus = (int) (karyawans.get(i).getgaji()*0.1);
					karyawans.get(i).setgaji(total+bonus);
					if (exist == 0) 
					{
						System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id " + karyawans.get(i).getID());
						exist = 1;
					}
					else System.out.print(", " + karyawans.get(i).getID());
				}
			}
		}
		else if (sctr >= 3)
		{
			exist=0;
			for (int i=0; i<karyawans.size(); i++)
			{
				if (karyawans.get(i).getjabatan().compareTo("Supervisor") == 0) 
				{
					total = karyawans.get(i).getgaji();
					bonus = (int) (karyawans.get(i).getgaji()*0.075);
					karyawans.get(i).setgaji(total+bonus);
					if (exist == 0) 
					{
						System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id " + karyawans.get(i).getID());
						exist = 1;
					}
					else System.out.print(", " + karyawans.get(i).getID());
			
				}
			}
		}
		else if (actr >= 3)
		{
			exist=0;
			for (int i=0; i<karyawans.size(); i++)
			{
				if (karyawans.get(i).getjabatan().compareTo("Admin") == 0) 
				{
					total = karyawans.get(i).getgaji();
					bonus = (int) (karyawans.get(i).getgaji()*0.005);
					karyawans.get(i).setgaji(total+bonus);
					if (exist == 0) 
					{
						System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id " + karyawans.get(i).getID());
						exist = 1;
					}
					else System.out.print(", " + karyawans.get(i).getID());
				}
			}
		}
		if(role.compareTo("Manager") == 0) karyawans.add(new Karyawan(ID, name, gender, role, 8000000));
		else if (role.compareTo("Supervisor") == 0) karyawans.add(new Karyawan(ID, name, gender, role, 6000000));
		else if (role.compareTo("Admin") == 0) karyawans.add(new Karyawan(ID, name, gender, role, 4000000));
		Collections.sort(karyawans);
		System.out.println("\nENTER to return"); sc.nextLine();
	}	
	void UpdateData() //ok
	{
		int id;
		String name, gender, role;
		ViewData();
		System.out.println("Input nomor urutan karyawan yang ingin diupdate: ");
		id = sc.nextInt(); sc.nextLine();
		if (id != 0 && karyawans.get(id-1) != null)
		{
			while(true)
			{
				System.out.println("Input nama karyawan [>= 3]: ");
				name = sc.nextLine();
				if(name.length() >= 3) 
				{
					karyawans.get(id-1).setnama(name);
					break;
				}
				else if (name.compareTo("0") == 0) break;
			}
			while(true)
			{
				System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
				gender = sc.nextLine();
				if (gender.compareTo("Laki-laki") == 0 || gender.compareTo("Perempuan") == 0) 
				{
					karyawans.get(id-1).setgender(gender);
					break;
				}
				else if (gender.compareTo("0") == 0) break;
			}
			while(true)
			{
				System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
				role = sc.nextLine();
				if (role.compareTo("Manager") == 0 || role.compareTo("Supervisor") == 0 || role.compareTo("Admin") == 0)
				{
					karyawans.get(id-1).setjabatan(role);
					if(role.compareTo("Manager") == 0) karyawans.get(id-1).setgaji(8000000);
					else if (role.compareTo("Supervisor") == 0) karyawans.get(id-1).setgaji(6000000);
					else if (role.compareTo("Admin") == 0) karyawans.get(id-1).setgaji(4000000);
					break;
				}
				else if (role.compareTo("0") == 0) break;
			}
			System.out.println("Berhasil mengupdate karyawan dengan id " + karyawans.get(id-1).ID);
		}
		Collections.sort(karyawans);
		System.out.println("ENTER to return"); sc.nextLine();
		
	}
	void RemoveData() //ok
	{
		ViewData();
		System.out.println("Input nomor urutan karyawan yang ingin dihapus: ");
		int id = sc.nextInt(); sc.nextLine();
		if (karyawans.get(id-1) != null)
		{
			System.out.printf("Karyawan dengan kode %s berhasil dihapus\n", karyawans.get(id-1).ID);
			karyawans.remove(id-1);
			Collections.sort(karyawans);
		}
		System.out.println("ENTER to return"); sc.nextLine();
	}
	
	public Main() 
	{
		// TODO Auto-generated constructor stub
		int choice;
		while(true)
		{
			Menu();
			choice = sc.nextInt();sc.nextLine();
			if (choice == 1) InsertData();
			else if (choice == 2) 
			{
				ViewData(); sc.nextLine();
			}
			else if (choice == 3) UpdateData();
			else if (choice == 4) RemoveData();
			else if (choice == 0) break;
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Main();
	}

}
