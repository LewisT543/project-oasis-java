import {Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle} from "@/components/ui/card.tsx";
import React from "react";
import {Applicant} from "@/types/Applicant.ts";
import {objectToArray} from "@/utils/objectToArray.ts";


export const ApplicantCard: React.FC<Applicant> = ({ name, id, salary, expenses, netMonthly }) => {
  return (
    <Card className="flex flex-col w-[350px]">
      <CardHeader >
        <CardTitle >{name}</CardTitle>
        <CardDescription>Applicant ID: {id}</CardDescription>
      </CardHeader>
      <CardContent >
        <p>Salary: {salary}</p>
        <p>Expenses: {objectToArray(expenses).join(" - ")}</p>
        <p>Net Monthly: {netMonthly}</p>
      </CardContent>
      <CardFooter >
        <p>Footer</p>
      </CardFooter>
    </Card>
  )
}

// const ApplicantCardDetails: React.FC<{ salary: number, expenses: Expenses, netMonthly: number }> = ({ salary, expenses, netMonthly }) => {
//   return (
//     <>
//       <div>Salary: {salary}</div>
//       <div>
//         Expenses: {Object.entries(expenses).map(([k, v]) => )}
//       </div>
//     </>
//   )
// }