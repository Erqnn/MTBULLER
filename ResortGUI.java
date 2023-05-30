import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;


public class ResortGUI extends JFrame implements ActionListener {
    private ArrayList<Accommodation> accommodations;
    private ArrayList<Customer> customers;
    private ArrayList<TravelPackage> travelPackages;

    // GUI components
    private JTabbedPane tabbedPane;
    private JPanel accommodationsTab;
    private JPanel customersTab;
    private JPanel travelPackageTab;


    // Components for Accommodations tab
    private JButton displayAllAccommodationsBtn;
    private JButton displayAvailableAccommodationsBtn;
    private JList<String> accommodationsList; // Use a JList to display accommodations

    // Components for Customers tab
    private JButton addCustomerBtn;
    private JButton listCustomersBtn;

    // Components for Travel Packages tab
    private JButton createPackageBtn;
    private JButton addLiftPassBtn;
    private JButton addLessonFeesBtn;
    private JButton listPackagesBtn;
    private JButton savePackagesBtn;
    private JButton readPackagesBtn;

    public ResortGUI() {
        // Initialize data lists
        accommodations = new ArrayList<>();
        customers = new ArrayList<>();
        travelPackages = new ArrayList<>();

        // Set up the main frame
        setTitle("Mt Buller Winter Resort");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the tabbed pane
        tabbedPane = new JTabbedPane();

        // Create the panels for each tab
        accommodationsTab = new JPanel();
        customersTab = new JPanel();
        travelPackageTab = new JPanel();

        // Add the panels to the tabbed pane
        tabbedPane.addTab("Accommodations", accommodationsTab);
        tabbedPane.addTab("Customers", customersTab);
        tabbedPane.addTab("Travel Packages", travelPackageTab);

        // Set up the layout for each tab panel and add components

        // Accommodations tab
        accommodationsTab.setLayout(new BorderLayout());

        // Display All Accommodations button
        displayAllAccommodationsBtn = new JButton("Display All Accommodations");
        displayAllAccommodationsBtn.addActionListener(this);
        accommodationsTab.add(displayAllAccommodationsBtn, BorderLayout.NORTH);

        // Display Available Accommodations button
        displayAvailableAccommodationsBtn = new JButton("Display Available Accommodations");
        displayAvailableAccommodationsBtn.addActionListener(this);
        accommodationsTab.add(displayAvailableAccommodationsBtn, BorderLayout.CENTER);

        // JList to display accommodations
        accommodationsList = new JList<>();
        accommodationsTab.add(new JScrollPane(accommodationsList), BorderLayout.SOUTH);

        // Customers tab
        customersTab.setLayout(new BorderLayout());

        // Add Customer button
        addCustomerBtn = new JButton("Add Customer");
        addCustomerBtn.addActionListener(this);
        customersTab.add(addCustomerBtn, BorderLayout.NORTH);

        // List Customers button
        listCustomersBtn = new JButton("List Customers");
        listCustomersBtn.addActionListener(this);
        customersTab.add(listCustomersBtn, BorderLayout.CENTER);


            // Travel Packages tab
travelPackageTab.setLayout(new GridLayout(3, 2));

// Create Package button
createPackageBtn = new JButton("Create Package");
createPackageBtn.addActionListener(this);
travelPackageTab.add(createPackageBtn);

// Add Lift Pass button
addLiftPassBtn = new JButton("Add Lift Pass to Package");
addLiftPassBtn.addActionListener(this);
travelPackageTab.add(addLiftPassBtn);

// Add Lesson Fees button
addLessonFeesBtn = new JButton("Add Lesson Fees to Package");
addLessonFeesBtn.addActionListener(this);
travelPackageTab.add(addLessonFeesBtn);

// List Packages button
listPackagesBtn = new JButton("List Packages");
listPackagesBtn.addActionListener(this);
travelPackageTab.add(listPackagesBtn);

// Save Packages button
savePackagesBtn = new JButton("Save Packages");
savePackagesBtn.addActionListener(this);
travelPackageTab.add(savePackagesBtn);

// Read Packages button
readPackagesBtn = new JButton("Read Packages");
readPackagesBtn.addActionListener(this);
travelPackageTab.add(readPackagesBtn);


        
        // Add the tabbed pane to the main frame
        getContentPane().add(tabbedPane);

        // Set the size and make the frame visible
        setSize(800, 700);
        setVisible(true);

        // Call the method to populate accommodations
        populateAccommodations();

                // Call the method to populate customers
                populateCustomers();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayAllAccommodationsBtn) {
            // Handle Display All Accommodations button click
            displayAllAccommodations();
        } else if (e.getSource() == displayAvailableAccommodationsBtn) {
            // Handle Display Available Accommodations button click
            displayAvailableAccommodations();
        } else if (e.getSource() == addCustomerBtn) {
            // Handle Add Customer button click
            addCustomer();
        } else if (e.getSource() == listCustomersBtn) {
            // Handle List Customers button click
            listCustomers();
        } else if (e.getSource() == createPackageBtn) {
            // Handle Create Package button click
            createTravelPackage();
        } else if (e.getSource() == addLiftPassBtn) {
            // Handle Add Lift Pass button click
            addLiftPass();
        } else if (e.getSource() == addLessonFeesBtn) {
            // Handle Add Lesson Fees button click
            addLessonFees();
        } else if (e.getSource() == listPackagesBtn) {
            // Handle List Packages button click
            listPackages();
        } else if (e.getSource() == savePackagesBtn) {
            // Handle Save Packages button click
            savePackages();
        } else if (e.getSource() == readPackagesBtn) {
            // Handle Read Packages button click
            readPackages();
        }
    }
    

    public void populateAccommodations() {
        accommodations.add(new Accommodation("Mount", 150, true, "Mount Accommodation 1"));
        accommodations.add(new Accommodation("BullerChalet", 200, true, "Buller Chalet 1"));
        accommodations.add(new Accommodation("MountainLodge", 100, false, "Mountain Lodge 1"));
        accommodations.add(new Accommodation("BullerChalet", 200, true, "Buller Chalet 2"));
        accommodations.add(new Accommodation("BullerLodge", 400, false, "Buller Lodge 1"));
        accommodations.add(new Accommodation("MountainChalet", 200, true, "Mountain Chalet 1"));
        accommodations.add(new Accommodation("MtBullerLodge", 100, false, "Mt. Buller Lodge 1"));
        accommodations.add(new Accommodation("BullerChalet", 200, true, "Buller Chalet 3"));
        accommodations.add(new Accommodation("ResortLodge", 100, false, "Resort Lodge 1"));
        accommodations.add(new Accommodation("MTBULLERLodge", 100, false, "Mt. Buller Lodge 2"));
        // Add more accommodations as needed
    }
    
    private void displayAllAccommodations() {
        // Create a DefaultListModel to hold the accommodations
        DefaultListModel<String> model = new DefaultListModel<>();

        // Iterate over accommodations and add each one to the model
        for (Accommodation accommodation : accommodations) {
            model.addElement(accommodation.toString());
        }

        // Set the model for the accommodationsList
        accommodationsList.setModel(model);
    }

    private void displayAvailableAccommodations() {
        // Create a DefaultListModel to hold the available accommodations
        DefaultListModel<String> model = new DefaultListModel<>();

        // Iterate over accommodations and add each available one to the model
        for (Accommodation accommodation : accommodations) {
            if (accommodation.isAvailable()) {
                model.addElement(accommodation.toString());
            }
        }

        // Set the model for the accommodationsList
        accommodationsList.setModel(model);
    }

    public void populateCustomers() {
        customers.add(new Customer("John Doe", "Intermediate"));
        customers.add(new Customer("Jane Smith", "Beginner"));
        customers.add(new Customer("Michael Johnson", "Advanced"));
        customers.add(new Customer("Emily Davis", "Intermediate"));
        // Add more customers as needed
    }

    private void addCustomer() {
        // Prompt for customer information
        String name = JOptionPane.showInputDialog(this, "Enter customer name:");
        if (name == null || name.isEmpty()) {
            // If the name is not provided, return without adding the customer
            return;
        }

        String skiLevel = JOptionPane.showInputDialog(this, "Enter customer ski level:");

        // Create a new Customer object
        Customer customer = new Customer(name, skiLevel);

        // Add the customer to the customers ArrayList
        customers.add(customer);

        // Display a success message
        JOptionPane.showMessageDialog(this, "Customer added successfully.");
    }

    private void listCustomers() {
        StringBuilder result = new StringBuilder();

        // Iterate over the customers ArrayList and append each customer's information to the result
        for (Customer customer : customers) {
            result.append(customer.toString()).append("\n");
        }

        // Display the customer list using JOptionPane
        JOptionPane.showMessageDialog(this, result.toString(), "Customers", JOptionPane.PLAIN_MESSAGE);
    }

    private void createTravelPackage() {
        // Prompt for package details
        String accommodationName = JOptionPane.showInputDialog(this, "Enter accommodation name:");
        LocalDate startDate = LocalDate.now();  // Example start date
    
        // Find the accommodation by name
        Accommodation accommodation = findAccommodationByName(accommodationName);
        if (accommodation == null) {
            // If the accommodation does not exist, display an error message
            JOptionPane.showMessageDialog(this, "Accommodation not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        // Prompt for other package details
        int days = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter number of days:"));
        double total = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter total amount:"));
    
        // Prompt for customer details and create a Customer object
        String customerName = JOptionPane.showInputDialog(this, "Enter customer name:");
        // Add any other necessary prompts for customer details
    
        // Create a new Customer object
        Customer customer = new Customer(customerName);  // Instantiate the Customer object
    
        // Create a new TravelPackage object
        TravelPackage travelPackage = new TravelPackage(accommodation, startDate, days, total, customer);
    
        // Add the accommodation to the travelPackage
        travelPackage.setAccommodation(accommodation);
    
        // Add the package to the travelPackages ArrayList
        travelPackages.add(travelPackage);
    
        // Display a success message
        JOptionPane.showMessageDialog(this, "Package created successfully.");
    }
    
    

    private void addLiftPass() {
        // Prompt for package ID
        String packageId = JOptionPane.showInputDialog(this, "Enter package ID:");
        if (packageId == null || packageId.isEmpty()) {
            // If the package ID is not provided, return without adding the lift pass
            return;
        }

        // Check if the package exists
        TravelPackage travelPackage = findTravelPackageById(packageId);
        if (travelPackage == null) {
            // If the package does not exist, display an error message
            JOptionPane.showMessageDialog(this, "Package not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Prompt for lift pass details
        String liftPassType = JOptionPane.showInputDialog(this, "Enter lift pass type:");
        String liftPassDuration = JOptionPane.showInputDialog(this, "Enter lift pass duration (in days):");

        // Add the lift pass to the package
        travelPackage.addLiftPass(liftPassType, Integer.parseInt(liftPassDuration));

        // Display a success message
        JOptionPane.showMessageDialog(this, "Lift pass added to package successfully.");
    }

    private void addLessonFees() {
        // Prompt for package ID
        String packageId = JOptionPane.showInputDialog(this, "Enter package ID:");
        if (packageId == null || packageId.isEmpty()) {
            // If the package ID is not provided, return without adding the lesson fees
            return;
        }

        // Check if the package exists
        TravelPackage travelPackage = findTravelPackageById(packageId);
        if (travelPackage == null) {
            // If the package does not exist, display an error message
            JOptionPane.showMessageDialog(this, "Package not found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Prompt for lesson fee details
        String lessonType = JOptionPane.showInputDialog(this, "Enter lesson type:");
        String lessonDuration = JOptionPane.showInputDialog(this, "Enter lesson duration (in hours):");

        // Add the lesson fees to the package
        travelPackage.addLessonFees(lessonType, Integer.parseInt(lessonDuration));

        // Display a success message
        JOptionPane.showMessageDialog(this, "Lesson fees added to package successfully.");
    }



    
    private void listPackages() {
        StringBuilder result = new StringBuilder();
    
        // Iterate over the travelPackages ArrayList and append each package's information to the result
        for (TravelPackage travelPackage : travelPackages) {
            result.append(travelPackage.toString()).append("\n");
            
            // Check if the package has a Lift Pass
            if (travelPackage.hasLiftPass()) {
                result.append("Package includes Lift Pass\n");
            } else {
                result.append("Package does not include Lift Pass\n");
            }
            
            result.append("------------------------\n");
        }
    
        // Display the package list using JOptionPane
        JOptionPane.showMessageDialog(this, result.toString(), "Travel Packages", JOptionPane.PLAIN_MESSAGE);
    }




    private void savePackages() {
        // Prompt for the file name
        String fileName = JOptionPane.showInputDialog(this, "Enter file name to save packages:");
    
        try {
            // Create a FileOutputStream with the specified file name
            FileOutputStream fileOut = new FileOutputStream(fileName);
    
            // Create an ObjectOutputStream to write objects to the file
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
    
            // Write the travelPackages ArrayList to the file
            objectOut.writeObject(travelPackages);
    
            // Close the ObjectOutputStream and FileOutputStream
            objectOut.close();
            fileOut.close();
    
            // Display a success message
            JOptionPane.showMessageDialog(this, "Packages saved successfully.");
        } catch (IOException ex) {
            // Display an error message if an exception occurs
            JOptionPane.showMessageDialog(this, "Error occurred while saving packages.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }





    private void readPackages() {
        // Prompt for the file name
        String fileName = JOptionPane.showInputDialog(this, "Enter file name to read packages:");
    
        try {
            // Create a FileInputStream with the specified file name
            FileInputStream fileIn = new FileInputStream(fileName);
    
            // Create an ObjectInputStream to read objects from the file
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
    
            // Read the object from the file
            Object obj = objectIn.readObject();
    
            // Check if the object is an ArrayList
            if (obj instanceof ArrayList<?>) {
                // Cast the object to ArrayList<?>
                ArrayList<?> temp = (ArrayList<?>) obj;
    
                // Create a new ArrayList<TravelPackage>
                travelPackages = new ArrayList<TravelPackage>();
    
                // Add all elements from the temporary list to the new list
                for (Object element : temp) {
                    if (element instanceof TravelPackage) {
                        travelPackages.add((TravelPackage) element);
                    }
                }
    
                // Display a success message
                JOptionPane.showMessageDialog(this, "Packages read successfully.");
            } else {
                // Display an error message if the object is not an ArrayList
                JOptionPane.showMessageDialog(this, "Invalid file format. Packages could not be read.", "Error", JOptionPane.ERROR_MESSAGE);
            }
    
            // Close the ObjectInputStream and FileInputStream
            objectIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException ex) {
            // Display an error message if an exception occurs
            JOptionPane.showMessageDialog(this, "Error occurred while reading packages.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    


    private Accommodation findAccommodationByName(String name) {
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getName().equalsIgnoreCase(name)) {
                return accommodation;
            }
        }
        return null;
    }

    private TravelPackage findTravelPackageById(String packageId) {
        // Search for the travel package with the specified ID
        for (TravelPackage travelPackage : travelPackages) {
            if (String.valueOf(travelPackage.getPackageID()).equals(packageId)) {
                return travelPackage;
            }
        }
        return null;
    }
    


    public static void main(String[] args) {
        ResortGUI resortGUI = new ResortGUI();
        resortGUI.pack();
        resortGUI.setVisible(true);
    }
}
