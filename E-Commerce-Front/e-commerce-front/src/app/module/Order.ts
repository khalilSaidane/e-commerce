import {OrderDetails} from './OrderDetails';
import {Customer} from './Customer';
import {Payment} from './Payment';
import {Shipper} from './Shipper';

export interface Order {
  id: number;
  customer: Customer;
  orderNumber: number;
  payment: Payment;
  orderDate: Date;
  shipDate: Date;
  requiredDate: Date;
  shipper: Shipper;
  freight: number;
  saleTax: number;
  timeStamp: Date;
  transactStatus: number;
  errorLoc: string;
  errorMsg: string;
  isFulfilled: number;
  isDeleted: number;
  isPayed: number;
  paymentDate: Date;
  orderDetails: OrderDetails;
}
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;
// @ManyToOne
// @JsonIgnore
// private Customer customer;
// private int orderNumber;
// @OneToOne(mappedBy = "order_")
// @JsonIgnore
// private Payment payment;
// private Date orderDate;
// private Date shipDate;
// private Date requiredDate;
// @JsonIgnore
// @OneToOne(mappedBy = "order_")
// private Shipper shipper;
// private String freight;
// private float salesTax;
// private Date timeStamp;
// private String transactStatus;
// private String errorLoc;
// private String errorMsg;
// private int isFulfilled;
// private int isDeleted;
// private int isPayed;
// private Date paymentDate;
// @OneToOne(mappedBy = "order_")
// private OrderDetails orderDetails;
