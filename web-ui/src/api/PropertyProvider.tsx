import React, {createContext, ReactNode, useContext, useEffect, useState} from "react";
import axios, {AxiosResponse} from "axios";
import {Property} from "../types/Property.ts";

type PropertyContextType = {
  properties: Property[];
  loading: boolean;
  error: string | null;
}

const PropertyContext = createContext<PropertyContextType | undefined>(undefined)

export const usePropertyContext = (): PropertyContextType => {
  const context = useContext(PropertyContext)
  if (!context) throw new Error("usePropertyContext must be used within the PropertyProvider")
  return context
}

interface PropertyProviderProps { children: ReactNode; }
export const PropertyProvider: React.FC<PropertyProviderProps> = ({ children }) => {
  const [properties, setProperties] = useState<Property[]>([])
  const [loading, setLoading] = useState<boolean>(true)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    const fetchProperties = async () => {
      try {
        const response: AxiosResponse<Property[]> = await axios.get<Property[]>("http://localhost:8081/api/properties")
        setProperties(response.data)
        setLoading(false)
      } catch (error: any) {
        setError(error.message)
        setLoading(false)
      }
    }

    fetchProperties();
  }, [])

  const contextValues: PropertyContextType = {
    properties,
    loading,
    error
  }

  return (
    <PropertyContext.Provider value={contextValues}>
      {children}
    </PropertyContext.Provider>
  )

}