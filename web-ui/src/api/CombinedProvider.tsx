import React, {ReactNode} from "react";
import {PropertyProvider} from "./providers/PropertyProvider.tsx";
import {ApplicantsProvider} from "./providers/ApplicantProvider.tsx";

export type ProviderProps = {
  apiUrl: string,
  children: ReactNode
}

type CombinedProviderProps = {
  propertyUrl: string;
  applicantsUrl: string;
  children: ReactNode
}

export const CombinedProvider: React.FC<CombinedProviderProps> = ({ propertyUrl, applicantsUrl, children }) => {
  return (
    <PropertyProvider apiUrl={propertyUrl}>
      <ApplicantsProvider apiUrl={applicantsUrl}>
        {children}
      </ApplicantsProvider>
    </PropertyProvider>
  )
}