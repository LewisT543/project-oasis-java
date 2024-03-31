import {FC} from "react";
import {objectToArray} from "../utils/objectToArray.ts"
import {useApplicantsContext} from "../api/providers/ApplicantProvider.tsx";

export const ApplicantsList: FC = () => {
  const { data: applicants, loading, error } = useApplicantsContext();

  if (loading) return <div>loading</div>
  if (error) return <div>Error: {error.message}</div>
  if (!applicants) return null

  console.log(applicants)

  return (
    <div>
      <h1>Applicant List</h1>
      <ul>
        {applicants.map(applicant => (
          <li key={applicant.id}>
            {applicant.name} - {applicant.salary}
            <p>
              {objectToArray(applicant.expenses).join(" - ")}
            </p>
          </li>
        ))}
      </ul>
    </div>
  )
}