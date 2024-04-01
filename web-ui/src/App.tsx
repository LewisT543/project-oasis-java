import {CombinedProvider} from "./providers/CombinedProvider.tsx";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {PageLayout} from "./pages/PageLayout.tsx";
import {PropertiesList} from "./custom-components/PropertiesList.tsx";
import {HomePage} from "./pages/HomePage.tsx";
import {RouteNotFoundPage} from "./pages/RouteNotFoundPage.tsx";
import {ApplicantsHomePage} from "./pages/Applicants/ApplicantsHomePage.tsx";
import {CreateApplicantPage} from "@/pages/Applicants/CreateApplicantPage.tsx";
import {ApplicantsPageLayout} from "@/pages/Applicants/ApplicantsPageLayout.tsx";


function App() {
  return (
    <BrowserRouter>
      <CombinedProvider
        applicantsUrl={import.meta.env.VITE_APPLICANT_API_URL}
        propertyUrl={import.meta.env.VITE_PROPERTY_API_URL}
      >
        <Routes>
          <Route path={"/"} element={(<PageLayout />)} >
            <Route index element={<HomePage />} />
            <Route path={"properties"} element={<PropertiesList />} />
            <Route path={"applicants"} element={<ApplicantsPageLayout />} >
              <Route index element={<ApplicantsHomePage />}/>
              <Route path={"create"} element={<CreateApplicantPage />} />
            </Route>
            <Route path={"*"} element={<RouteNotFoundPage />} />
          </Route>
        </Routes>
      </CombinedProvider>
    </BrowserRouter>
  );
}

export default App
