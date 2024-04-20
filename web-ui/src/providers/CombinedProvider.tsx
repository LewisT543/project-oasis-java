import React, {ReactNode} from "react";
import {PropertyProvider} from "./PropertyProvider.tsx";
import {ApplicantsProvider} from "./ApplicantProvider.tsx";
import {ThemeProvider} from "@/providers/ThemeProvider.tsx";

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
    <ThemeProvider defaultTheme="dark" storageKey="vite-ui-theme">
      {/*<PropertyProvider apiUrl={propertyUrl}>*/}
        <ApplicantsProvider apiUrl={applicantsUrl}>
          {children}
        </ApplicantsProvider>
      {/*</PropertyProvider>*/}
    </ThemeProvider>
  )
}