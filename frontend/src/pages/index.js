import React from "react"
import { Link } from "gatsby"

import Layout from "../components/layout"
import Image from "../components/image"
import SEO from "../components/seo"
import CampaignWrapper from "../components/campaignWrapper"

const IndexPage = () => (
  <Layout>
    <h1>Random Active Campaign</h1>
    <CampaignWrapper />
  </Layout>
)

export default IndexPage
