package many_to_one_bank_dto_Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.action.spi.BeforeTransactionCompletionProcess;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import many_to_one_bank_dao.BankDAO;
import many_to_one_bank_dao.BranchDao;
import many_to_one_bank_dto.Bank;
import many_to_one_bank_dto.Branch;
import net.bytebuddy.asm.Advice.Enter;

public class mainBank {

	public static void main(String[] args) {

		boolean condition = false;

		BankDAO bankDAO = new BankDAO();
		BranchDao branchDao = new BranchDao();
		do {
			System.out.println(" 1.Insert \n 2.Update \n 3.delete \n 4.retrive by id \n 5. get all");
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter choice ");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				Bank bank = new Bank();
				System.out.println("enter bank name ");
				String bankName = scanner.next();

				System.out.println("enter headoffice name");
				String headOfficeName = scanner.next();

				System.out.println("enter ceo name");
				String bankCeoNAme = scanner.next();

				bank.setName(bankCeoNAme);
				bank.setHeadoffice(headOfficeName);
				bank.setCeo(bankCeoNAme);

				Branch b1 = new Branch();

				System.out.println("enter ifsc code");
				String ifsccode = scanner.next();

				System.out.println("set bank name");
				String setName = scanner.next();

				System.out.println("set Addreess name");
				String setAddress = scanner.next();

				System.out.println("set SetMAnger name");
				String setMangerNAme = scanner.next();

				System.out.println("set bank name");
				Long Phone = scanner.nextLong();

				b1.setIfsc(ifsccode);
				b1.setName(setName);
				b1.setAddress(setAddress);
				b1.setManager(setMangerNAme);
				b1.setPhone(Phone);

				Branch b2 = new Branch();

				System.out.println("enter ifsc code");
				String ifsccode1 = scanner.next();

				System.out.println("set bank name");
				String setName1 = scanner.next();

				System.out.println("set Addreess name");
				String setAddress1 = scanner.next();

				System.out.println("set SetMAnger name");
				String setMangerNAme1 = scanner.next();

				System.out.println("set bank name");
				Long Phone1 = scanner.nextLong();

				b2.setIfsc(ifsccode1);
				b2.setName(setMangerNAme1);
				b2.setAddress(setAddress1);
				b2.setManager(setMangerNAme1);
				b2.setPhone(Phone1);

				Branch b3 = new Branch();
				System.out.println("enter ifsc code");
				String ifsccode3 = scanner.next();

				System.out.println("set bank name");
				String setName3 = scanner.next();

				System.out.println("set Addreess name");
				String setAddress3 = scanner.next();

				System.out.println("set SetMAnger name");
				String setMangerNAme3 = scanner.next();

				System.out.println("set bank name");
				Long Phone3 = scanner.nextLong();

				b3.setIfsc(ifsccode3);
				b3.setName(setMangerNAme3);
				b3.setAddress(setAddress3);
				b3.setManager(setMangerNAme3);
				b3.setPhone(Phone3);

				b1.setBank(bank);
				b2.setBank(bank);
				b3.setBank(bank);

				List<Branch> list = new ArrayList<Branch>();
				list.add(b3);
				list.add(b1);
				list.add(b2);

				bankDAO.saveBank(bank);
				branchDao.saveBranch(list);

				break;
			}
			case 2: {
				System.out.println("eneter bank details t be updated");
				System.out.println("Enter id");
				int id = scanner.nextInt();
				System.out.println("enter name ");
				String name = scanner.next();
				bankDAO.updateBank(id, name);

				System.out.println("Enter branch details to updated");
				System.out.println("Enter id");
				int id1 = scanner.nextInt();
				System.out.println("enter name ");
				String name1 = scanner.next();
				branchDao.updateBranch(id1, name1);
				break;
			}
			case 3: {
				System.out.println("enter bank id to be deleted");
				int id = scanner.nextInt();
				bankDAO.deleteBank(1);

				System.out.println("enter branch id to be deleted");
				int id1 = scanner.nextInt();
				branchDao.deleteBranch(id1);
				break;
			}
			case 4: {
				System.out.println("enter bank id to be  retrived");
				int bankid = scanner.nextInt();
				bankDAO.getBankById(bankid);
				System.out.println("enter branch id to be deleted");
				int bid = scanner.nextInt();

				branchDao.getBranchById(bid);
				break;
			}
			case 5: {

				bankDAO.getAllBank();
				branchDao.getAllBranch();
				break;
			}

			default:
				break;
			}

		} while (condition);

	}

}
