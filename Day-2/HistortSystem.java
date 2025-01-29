import java.util.Scanner;

class Node {
    String page;
    Node next;
    Node prev;

    public Node(String page) {
        this.page = page;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    private Node head;
    private Node tail;
    private Node pointer;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.pointer = head;
    }

    public void insertAtHead(String page) {
        Node newNode = new Node(page);
        if(head == null) {
            head = tail = pointer = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        pointer = head;
        System.out.println("page created at start\n");

    }

    public void insertAtTail(String page) {
        Node newNode = new Node(page);
        if(tail == null) {
            head = tail = pointer = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        pointer = tail;
        System.out.println("page created at end\n");
    }

    public void deleteAtHead(){
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        if(head == tail) {
            head = tail = pointer = null;
            return;
        }
        head = head.next;
        head.prev = null;
        pointer = head;
        System.out.println("page deleted at start\n");

    }

    public void deleteAtTail(){
        if(tail == null) {
            System.out.println("List is empty!\n");
            return;
        }
        if(head == tail){
            head = tail = pointer = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        System.out.println("page deleted at end\n");

    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty!\n");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.page + (temp.next != null ? " <-> " : "\n"));
            temp = temp.next;
        }
        System.out.println();
    }

    public void forward() {
        if( pointer == null || pointer.next == null) {
            System.out.println("There is no further page available\n");
            return;
        }
        pointer = pointer.next;
        System.out.println("Next page is : " + pointer.page + "\n");
    }
    public void backward() {
        if( pointer == null || pointer.prev == null) {
            System.out.println("There is no previous page available\n");
            return;
        }
        pointer = pointer.prev;
        System.out.println("Pervious page is : " + pointer.page);   
    }
}

public class HistortSystem {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        boolean isRunning = true;
        
        while(isRunning) {

            Scanner sc = new Scanner(System.in);
            
            System.out.println("Options: ");
            System.out.println("1. create page");
            System.out.println("2. delete page");
            System.out.println("3. go to next page");
            System.out.println("4. go to previous page");
            System.out.println("5. show all pages");
            System.out.println("6. Exit application");

            System.out.print("Choose an option: ");
            int n = sc.nextInt();
            System.out.println();

            switch (n) {
                case 1:
                    System.out.println("1. create at end of all pages");
                    System.out.println("2. create at start of all pages\n");
                    System.out.print("choose an option: ");
                    int copt = sc.nextInt();
                    sc.nextLine();

                    switch (copt) {
                        case 1:
                            System.out.print("Enter page name: ");
                            String pname = sc.nextLine();
                            dll.insertAtTail(pname);
                            break;
                        case 2:
                            System.out.print("Enter page name: ");
                            String pname1 = sc.nextLine();
                            dll.insertAtHead(pname1);
                            break;
                        default:
                            System.out.println("Enter valid option");
                            break;
                    }
                    System.out.print("\nPages available : ");
                    dll.display();
                    System.out.println();
                    break;
                case 2:
                    System.out.println("1. delete at end of all pages");
                    System.out.println("2. delete at start of all pages\n");
                    System.out.println("choose an option: ");
                    int dopt = sc.nextInt();
                    switch (dopt) {
                        case 1:
                            dll.deleteAtTail();
                            dll.display();
                            break;
                        case 2:
                            dll.deleteAtHead();
                            dll.display();
                            break;
                        default:
                            System.out.println("Enter valid option");
                            break;
                    }
                break;
                case 3:
                    dll.forward();
                    break;
                case 4:
                    dll.backward();
                    break;
                case 5:
                    dll.display();
                    break;
                case 6:
                    System.out.println("Exiting application...\n");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Choose a valid option\n");
                    break;
            }
        }
    }
}