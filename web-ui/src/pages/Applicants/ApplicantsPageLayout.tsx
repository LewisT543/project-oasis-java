import React from "react";
import {ApplicantsMenu} from "@/custom-components/applicant/ApplicantsMenu.tsx";
import {Outlet} from "react-router-dom";

export const ApplicantsPageLayout: React.FC = () => {
  return (
    <div>
      <ApplicantsMenu />
      <Outlet />
    </div>
  )
}