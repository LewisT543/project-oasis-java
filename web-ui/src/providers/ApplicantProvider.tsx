import {Applicant} from "../types/Applicant.ts";
import React, {createContext} from "react";
import {useFetchData} from "@/hooks/useFetchData.ts";
import {ContextType} from "@/types/ContextType.ts";
import {useSafeContext} from "@/hooks/useSafeContext.ts";
import {ProviderProps} from "@/providers/CombinedProvider.tsx";


type ApplicantContextType = ContextType<Applicant>

const ApplicantsContext = createContext<ApplicantContextType>({
  data: null,
  loading: true,
  error: null
})

export const useApplicantsContext = useSafeContext<ApplicantContextType>(ApplicantsContext)

export const ApplicantsProvider: React.FC<ProviderProps> = ({ apiUrl, children }) => {
  const { data: applicants, loading, error } = useFetchData<Applicant[]>(apiUrl)

  return (
    <ApplicantsContext.Provider value={{ data: applicants, loading, error }}>
      {children}
    </ApplicantsContext.Provider>
  )
}

