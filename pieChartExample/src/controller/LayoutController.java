package controller;

import java.time.LocalDate;
import java.time.YearMonth;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Expense;
import model.Income;
import model.Management;
import model.Schedule;

public  class LayoutController {
	private static BorderPane root;
	private LoginController loginCon;
	private HomeController homeCon;
	public static ObservableList<Expense> expenses = FXCollections.observableArrayList();
	public static ObservableList<Income> incomes = FXCollections.observableArrayList();
	public static ObservableList<Schedule> schedules = FXCollections.observableArrayList();
	public static ObservableList<Management> management = FXCollections.observableArrayList();
	//int i;
	public LayoutController() {
		//expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,11),"교통","버스비",5000,"티머니 충전"));
		//incomes.add(new Income(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,6),"알바비",20000));
		//schedules.add(new Schedule(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,2),"축구","오메가배 풋살결승"));
	}

	
	public void setRootLayout() {
		try {
		root = FXMLLoader.load(getClass().getResource("/view/RootLayout.fxml"));
		Stage rootStage;
		Scene scene = new Scene(root);
		rootStage = Main.parentWindow;
		rootStage.setScene(scene);
		rootStage.setResizable(true);
		rootStage.centerOnScreen();
		/*ExpenseDAO expenseDAO = new ExpenseDAO();
		ObservableList<Expense> tempList = expenseDAO.getExpense();
		for(int i = 0; i<tempList.size();i++){
		expenses.add(tempList.get(i));
		}
		IncomeDAO incomeDAO = new IncomeDAO();
		ObservableList<Income> tempList1 = incomeDAO.getIncome();
		for(int j = 0; j<tempList1.size();j++){
		incomes.add(tempList1.get(j));
	    }*/
		/*
		expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,11),"교통","버스",5000,"티머니 충전"));
		expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,7,20),"유흥","술",34000,"동창회"));
		expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,5),"식비","점심",3500,"학식"));
		expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,7,4),"식비","저녁",8500,"독스마스"));
		expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,29),"교통","택시",5000,""));
		expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,5,4),"기타","알약",3000,""));
		expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,5,24),"기타","담배",4500,"레종"));
		expenses.add(new Expense(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,15),"식비","야식",17000,"치킨"));
		incomes.add(new Income(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,6),"알바비",20000));
		schedules.add(new Schedule(loginCon.users.get(loginCon.userNumber).getID(),LocalDate.of(2018,6,2),"축구","오메가배 풋살결승"));*/
		/*homeCon.differentiate.add(new Differentiate("",null,0));
		for(int i=0;i<expenses.size();i++) {
			for(int j=0;j<homeCon.differentiate.size();j++) {
				if(expenses.get(i).getDate().equals(homeCon.differentiate.get(j).getDate())) {
					homeCon.differentiate.get(j).addDayExpense(expenses.get(i).getExpense());
				}else {
					homeCon.differentiate.add(new Differentiate(expenses.get(i).getID(),expenses.get(i).getDate(),expenses.get(i).getExpense()));
				}
			}
		}*/
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setHome() {	
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/Home.fxml"));
			AnchorPane home = (AnchorPane) loader.load();
			HomeController controller = loader.getController();	
			controller.calendar.getChildren().clear();
			controller.calendar.getChildren().add(new CalendarController(YearMonth.now()).getView());
			controller.date=LocalDate.now();
			controller.setMain(this);
			root.setCenter(home);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setReport() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/Report.fxml"));
			VBox report = (VBox) loader.load();
			ReportController controller = loader.getController();
			controller.setReprot(this);
			root.setCenter(report);
			/*ExpenseDAO expenseDAO = new ExpenseDAO();
			ObservableList<Expense> tempList = expenseDAO.getExpense();
			for(int i = 0; i<tempList.size();i++){
			expenses.add(tempList.get(i));
			}
			IncomeDAO incomeDAO = new IncomeDAO();
			ObservableList<Income> tempList1 = incomeDAO.getIncome();
			for(int j = 0; j<tempList1.size();j++){
			incomes.add(tempList1.get(j));
		    }*/
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setBudget() {	
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/Budget.fxml"));
			AnchorPane budget = (AnchorPane) loader.load();
			root.setCenter(budget);
			BudgetController controller = loader.getController();
			controller.setBudget(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void setUser() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../view/User.fxml"));
			VBox User = (VBox) loader.load();
			root.setCenter(User);
			UserController controller = loader.getController();
			controller.setUser(loginCon.userNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void setpieChart() {
		try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("../view/pieChart.fxml"));
		AnchorPane pieChart = (AnchorPane) loader.load();
		root.setCenter(pieChart);
		pieChartController controller = loader.getController();
		controller.setpieChart(this);
	}catch(Exception e) {
		e.printStackTrace();
	}
	

}
	@FXML
	private void handleMouseClickHome(MouseEvent event) {
		setHome();
	}
	@FXML
	private void handleMouseClickReport(MouseEvent event) {
		setReport();
	}
	@FXML
	private void handleMouseClickBudget(MouseEvent event) {
		setBudget();
	}
	@FXML
	private void handleMouseClickpieChart(MouseEvent event) {
		setpieChart();
	}
	@FXML
	private void handleMouseClickUser(MouseEvent event) {
		setUser();
		UserController controller = new UserController();
	}
}
