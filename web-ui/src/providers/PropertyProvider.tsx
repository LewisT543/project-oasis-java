import React, {createContext} from "react";
import {Property} from "@/types/Property.ts";
import {ContextType} from "@/types/ContextType.ts";
import {useFetchData} from "@/hooks/useFetchData.ts";
import {useSafeContext} from "@/hooks/useSafeContext.ts";
import {ProviderProps} from "./CombinedProvider.tsx";

type PropertyContextType = ContextType<Property>

const PropertyContext = createContext<PropertyContextType>({
  data: null,
  loading: true,
  error: null
})

export const usePropertyContext = useSafeContext<PropertyContextType>(PropertyContext)

export const PropertyProvider: React.FC<ProviderProps> = ({ apiUrl, children }) => {
  const [{ data: properties, loading, error }] = useFetchData<Property[]>(apiUrl)

  return (
    <PropertyContext.Provider value={{ data: properties, loading, error }}>
      {children}
    </PropertyContext.Provider>
  )
}