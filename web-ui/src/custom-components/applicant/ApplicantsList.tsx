import {FC} from "react";
import {useApplicantsContext} from "@/providers/ApplicantProvider.tsx";
import {ApplicantCard} from "./ApplicantCard.tsx";

export const ApplicantsList: FC = () => {
  const { data: applicants, loading, error } = useApplicantsContext();

  if (loading) return <div>loading</div>
  if (error) return <div>Error: {error.message}</div>
  if (!applicants) return null

  return (
    <div>
      <h1 className="m-4">Applicant List</h1>
      <ul>
        {applicants.map((applicant, index) => (<ApplicantCard key={index} {...applicant}/>))}
      </ul>
    </div>
  )
}