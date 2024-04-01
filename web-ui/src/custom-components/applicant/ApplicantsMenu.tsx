import {Card, CardHeader, CardTitle} from "@/components/ui/card.tsx";
import {Link} from "react-router-dom";
import {ROUTES} from "@/pages/routes.ts";

export const ApplicantsMenu = () => {
  return (
    <Card className="flex flex-row justify-start  ">
      <CardHeader>
        <CardTitle >Applicants Menu: </CardTitle>
      </CardHeader>
      <CardHeader>
        <Link to={ROUTES.applicants.CREATE}>Create New Applicant</Link>
      </CardHeader>
    </Card>
  )
}

