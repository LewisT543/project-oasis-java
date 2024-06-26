export type Applicant = {
  id: string;
  name: string;
  salary: number;
  netMonthly: number;
  expenses: Expenses;
}

export type Expenses = {
  loans: number;
  rent: number;
  bills: number;
  food: number;
  other: number;
  total: number;
}
