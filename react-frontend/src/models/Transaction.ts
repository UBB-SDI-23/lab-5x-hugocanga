export interface Transaction {
    id?: number;
    orderId: number;
    paymentMethod: string;
    amount: number;
    date: string;
  }