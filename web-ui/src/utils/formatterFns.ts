
const UKCurrenyFormatter = new Intl.NumberFormat("en-uk", {
  style: "currency",
  currency: "GBP",
})

export const formatNumber = (amount: number): string => {
  return UKCurrenyFormatter.format(amount)
}

export const formatPropertyType = (propType: string): string => {
  return propType.toLowerCase().split("_").map(word => word.charAt(0).toUpperCase() + word.slice(1)).join(" ")
}

type DateStringFormatterVariant = "short-date" | "long-date" | "other"
export const formatDTStringTo = (dateTime: string, variant: DateStringFormatterVariant = "short-date"): string => {
  switch (variant ?? "short-date") {
    case "short-date": return dateTime.split("T")[0]
    default: return dateTime
  }
}